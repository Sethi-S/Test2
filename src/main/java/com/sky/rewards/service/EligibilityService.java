package com.sky.rewards.service;

import com.sky.rewards.InvalidAccountNumberException;
import com.sky.rewards.value.CustomerEligiblityValue;

/**
 * Created by Rajesh on 20-May-17.
 */
public interface EligibilityService {
    CustomerEligiblityValue getCustomerEligibility(Integer account) throws InvalidAccountNumberException;

    boolean isValidAccount(Integer account);
}
