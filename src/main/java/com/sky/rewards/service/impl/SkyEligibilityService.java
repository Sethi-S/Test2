package com.sky.rewards.service.impl;

import com.sky.rewards.InvalidAccountNumberException;
import com.sky.rewards.service.EligibilityService;
import com.sky.rewards.value.CustomerEligiblityValue;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rajesh on 20-May-17.
 */
@Service
public class SkyEligibilityService implements EligibilityService {
    private List<Integer> validAccounts = Arrays.asList(1, 2, 3, 4, 5);
    private List<Integer> invalidAccounts = Arrays.asList(6, 7, 8, 9, 10);

    @Override
    public CustomerEligiblityValue getCustomerEligibility(Integer account) throws InvalidAccountNumberException {
        if (validAccounts.contains(account))
            return CustomerEligiblityValue.CUSTOMER_ELIGIBLE;
        else if (invalidAccounts.contains(account))
            return CustomerEligiblityValue.CUSTOMER_INELIGIBLE;
        else
            throw new InvalidAccountNumberException("Account " + account + " is not in the list");
    }

    @Override
    public boolean isValidAccount(Integer account) {
        return validAccounts.contains(account);
    }
}
