package com.sky.rewards.value;

import com.sky.rewards.InvalidChannelException;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ChannelValue {

    SPORTS("SPORTS"),
    KIDS("KIDS"),
    MUSIC("MUSIC"),
    NEWS("NEWS"),
    MOVIES("MOVIES");

    private static final Map<String, ChannelValue> STRING_CHANNEL_VALUE_MAP = new HashMap<>();

    static {
        for (ChannelValue s : EnumSet.allOf(ChannelValue.class)) {
            STRING_CHANNEL_VALUE_MAP.put(s.description, s);
        }
    }

    private String description;

    private ChannelValue(String description) {
        this.description = description;
    }

    public static final ChannelValue getChannelValue(String description) throws InvalidChannelException {
        if (!STRING_CHANNEL_VALUE_MAP.containsKey(description))
            throw new InvalidChannelException(description + " is not supported");
        return STRING_CHANNEL_VALUE_MAP.get(description);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}
