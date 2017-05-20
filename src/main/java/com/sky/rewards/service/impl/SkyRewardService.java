package com.sky.rewards.service.impl;

import com.sky.rewards.InvalidAccountNumberException;
import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.service.EligibilityService;
import com.sky.rewards.service.RewardBusiness;
import com.sky.rewards.service.RewardService;
import com.sky.rewards.value.ChannelValue;
import com.sky.rewards.value.CustomerEligiblityValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Rajesh on 20-May-17.
 */
@Service
public class SkyRewardService implements RewardService {

    @Autowired
    private EligibilityService eligibilityService;

    @Override
    public Reward getRewards(Integer accountId, Portfolio portfolio) throws InvalidAccountNumberException {
        validateAccount(accountId);
        Reward reward = new Reward();
        reward.setAccount(accountId);
        CustomerEligiblityValue eligibleType = eligibilityService.getCustomerEligibility(accountId);
        if (eligibleType.equals(CustomerEligiblityValue.CUSTOMER_INELIGIBLE)) {
            reward.setRewardValues(Collections.emptyList());
            reward.setMessage("Customer is not eligible for Rewards");
        } else if (eligibleType.equals(CustomerEligiblityValue.CUSTOMER_ELIGIBLE)) {
            RewardBusiness rewardBusiness = getRewardBusiness();
            Set<ChannelValue> channelValueSet = portfolio.getChannelValues();
            List<String> rewardValueList = rewardBusiness.getReward(channelValueSet);
            reward.setRewardValues(rewardValueList);
            if (rewardValueList.size() == 0)
                reward.setMessage("Customer is not eligible for rewards");
        }
        return reward;
    }

    private void validateAccount(Integer accountId) throws InvalidAccountNumberException {
        if (accountId == null)
            throw new InvalidAccountNumberException("Account is empty");
    }

    private RewardBusiness getRewardBusiness() {
        return new RewardBusinessImpl();
    }
}
