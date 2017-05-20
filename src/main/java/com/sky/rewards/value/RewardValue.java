package com.sky.rewards.value;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum RewardValue {

    CHAMPIONS_LEAGUE_FINAL_TICKET("CHAMPIONS LEAGUE FINAL TICKET"),
    KARAOKE_PRO_MICROPHONE("KARAOKE PRO MICROPHONE"),
    PIRATES_OF_THE_CARIBBEAN_COLLECTION("PIRATES OF THE CARIBBEAN COLLECTION");

    private static final Map<String, RewardValue> STRING_REWARD_VALUE_MAP = new HashMap<>();

    static {
        for (RewardValue s : EnumSet.allOf(RewardValue.class)) {
            STRING_REWARD_VALUE_MAP.put(s.getDescription(), s);
        }
    }

    private String description;


    private RewardValue(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}
