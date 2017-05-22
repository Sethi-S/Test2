package com.sky.rewards;

import com.sky.rewards.service.impl.SimpleRewardBusiness;
import com.sky.rewards.value.ChannelValue;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rajesh on 20-May-17.
 */
public class RewardBusinessTest {

    @Test
    public void givenSomeValidChannelsThenReturnAList() {
        SimpleRewardBusiness rewardBusiness = new SimpleRewardBusiness();
        Set<ChannelValue> channelTypeSet = new HashSet<>(2);
        channelTypeSet.add(ChannelValue.KIDS);
        channelTypeSet.add(ChannelValue.MOVIES);
        List<String> rewardList = rewardBusiness.getReward(channelTypeSet);
        assertThat(rewardList).isNotEmpty();
    }

    @Test
    public void givenKidsChannelThenReturnNoRewards() {
        SimpleRewardBusiness rewardBusiness = new SimpleRewardBusiness();
        Set<ChannelValue> channelTypeSet = new HashSet<>(2);
        channelTypeSet.add(ChannelValue.KIDS);
        List<String> rewardList = rewardBusiness.getReward(channelTypeSet);
        assertThat(rewardList).isEmpty();
    }

    @Test
    public void givenSportsChannelThenReturnChampions() {
        SimpleRewardBusiness rewardBusiness = new SimpleRewardBusiness();
        Set<ChannelValue> channelTypeSet = new HashSet<>(2);
        channelTypeSet.add(ChannelValue.SPORTS);
        List<String> rewardList = rewardBusiness.getReward(channelTypeSet);
        assertThat(rewardList).containsExactly("CHAMPIONS LEAGUE FINAL TICKET");
    }

    @Test
    public void givenSportsAndKidsChannelThenReturnChampions() {
        SimpleRewardBusiness rewardBusiness = new SimpleRewardBusiness();
        Set<ChannelValue> channelTypeSet = new HashSet<>(2);
        channelTypeSet.add(ChannelValue.SPORTS);
        channelTypeSet.add(ChannelValue.KIDS);
        List<String> rewardList = rewardBusiness.getReward(channelTypeSet);
        assertThat(rewardList).containsExactly("CHAMPIONS LEAGUE FINAL TICKET");
    }
}