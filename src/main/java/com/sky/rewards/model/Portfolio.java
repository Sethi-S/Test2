package com.sky.rewards.model;

import com.sky.rewards.InvalidChannelException;
import com.sky.rewards.value.ChannelSubscriptions;
import com.sky.rewards.value.ChannelValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rajesh on 20-May-17.
 */
public class Portfolio {
    private static final Logger log = LoggerFactory.getLogger(Portfolio.class);
    protected Set<ChannelValue> channelValues = new HashSet<>(5);

    public Portfolio(ChannelSubscriptions channelSubscriptions) throws InvalidChannelException {
        String[] subscriptions = channelSubscriptions.getChannels();
        if (subscriptions == null || subscriptions.length == 0)
            throw new InvalidChannelException("No channels in the Portfolio");
        for (int i = 0; i < subscriptions.length; i++) {
            channelValues.add(ChannelValue.getChannelValue(subscriptions[i]));
        }
        log.info(channelValues.toString());
    }

    public Set<ChannelValue> getChannelValues() {
        return channelValues;
    }

}
