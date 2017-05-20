package com.sky.rewards.service;

import com.sky.rewards.value.ChannelValue;

import java.util.List;
import java.util.Set;

/**
 * Created by Rajesh on 20-May-17.
 */
public interface RewardBusiness {
    //Should this be an Optional ?
    List<String> getReward(Set<ChannelValue> channelTypes);
}
