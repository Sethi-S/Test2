package com.sky.rewards.model;

import java.util.List;

/**
 * Created by Rajesh on 20-May-17.
 */
public class Reward {
    private Integer account;
    private List<String> rewardValues;
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public List<String> getRewardValues() {
        return rewardValues;
    }

    public void setRewardValues(List<String> rewardValues) {
        this.rewardValues = rewardValues;
    }
}
