package com.sky.rewards.service;

import com.sky.rewards.InvalidAccountNumberException;
import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;

/**
 * Created by Rajesh on 20-May-17.
 */
public interface RewardService {
    Reward getRewards(Integer accountId, Portfolio portfolio) throws InvalidAccountNumberException;
}
