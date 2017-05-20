package com.sky.rewards.service.impl;

import com.sky.rewards.service.RewardBusiness;
import com.sky.rewards.value.ChannelValue;
import com.sky.rewards.value.RewardValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Rajesh on 20-May-17.
 */
public class RewardBusinessImpl implements RewardBusiness {
    @Override
    public List<String> getReward(Set<ChannelValue> channelTypeSet) {
        List<String> list = new ArrayList<>();
        Iterator<ChannelValue> channelValueIterator = channelTypeSet.iterator();
        while (channelValueIterator.hasNext()) {
            ChannelValue channelValue = channelValueIterator.next();
            if (channelValue.equals(ChannelValue.SPORTS)) {
                list.add(RewardValue.CHAMPIONS_LEAGUE_FINAL_TICKET.getDescription());
            } else if (channelValue.equals(ChannelValue.MOVIES)) {
                list.add(RewardValue.PIRATES_OF_THE_CARIBBEAN_COLLECTION.getDescription());
            } else if (channelValue.equals(ChannelValue.MUSIC)) {
                list.add(RewardValue.KARAOKE_PRO_MICROPHONE.getDescription());
            }
        }
        return list;
    }
}
