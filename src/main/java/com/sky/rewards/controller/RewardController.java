package com.sky.rewards.controller;

import com.sky.rewards.InvalidAccountNumberException;
import com.sky.rewards.InvalidChannelException;
import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.service.RewardService;
import com.sky.rewards.value.ChannelSubscriptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class RewardController {

    private static final Logger log = LoggerFactory.getLogger(RewardController.class);

    @Autowired
    private RewardService rewardService;

    @RequestMapping(value = "/rewards", method = RequestMethod.POST)
    public Reward getReward(@RequestBody ChannelSubscriptions channelSubscriptions) {
        log.info("Reward controller invoked");
        Reward reward = new Reward();
        try {
            Integer accountid = channelSubscriptions.getAccountid();
            Portfolio portfolio = new Portfolio(channelSubscriptions);
            reward = rewardService.getRewards(accountid, portfolio);
            reward.setSuccess(true);
            if (reward.getMessage() == null) reward.setMessage("Successful Response for Rewards");
        } catch (InvalidChannelException | InvalidAccountNumberException e) {
            setExceptionMessage(reward, e);
        } catch (Exception e) {
            setExceptionMessage(reward, e);
        }
        return reward;
    }

    private void setExceptionMessage(Reward reward, Exception e) {
        reward.setRewardValues(Collections.emptyList());
        reward.setSuccess(false);
        reward.setMessage(e.getMessage());
    }
}
