package com.sky.rewards.value;

/**
 * Created by Rajesh on 20-May-17.
 */
public class ChannelSubscriptions {
    private String[] channels;

    private Integer accountid;

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String[] getChannels() {
        return channels;
    }

    public void setChannels(String[] channels) {
        this.channels = channels;
    }
}
