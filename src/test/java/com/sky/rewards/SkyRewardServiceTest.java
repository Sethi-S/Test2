package com.sky.rewards;

import com.sky.rewards.model.Portfolio;
import com.sky.rewards.model.Reward;
import com.sky.rewards.service.EligibilityService;
import com.sky.rewards.service.impl.SkyRewardService;
import com.sky.rewards.value.ChannelSubscriptions;
import com.sky.rewards.value.CustomerEligiblityValue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Created by Rajesh on 20-May-17.
 */
public class SkyRewardServiceTest {
    @Mock
    public EligibilityService eligibilityService;

    @InjectMocks
    public SkyRewardService rewardService = new SkyRewardService();

    @Before
    public void initilizeBeforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRewards() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {"KIDS", "MUSIC"};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(1);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenReturn(CustomerEligiblityValue.CUSTOMER_ELIGIBLE);
        Reward reward = rewardService.getRewards(1, portfolio);
        assertThat(reward).isNotNull();
        assertThat(reward.getAccount()).isEqualTo(1);
        assertThat(reward.getRewardValues()).containsExactly("KARAOKE PRO MICROPHONE");
    }

    @Test
    public void givenAllChannelsReturn3Rewards() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {"KIDS", "MUSIC", "SPORTS", "NEWS", "MOVIES"};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(1);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenReturn(CustomerEligiblityValue.CUSTOMER_ELIGIBLE);
        Reward reward = rewardService.getRewards(1, portfolio);
        assertThat(reward).isNotNull();
        assertThat(reward.getAccount()).isEqualTo(1);
        assertThat(reward.getRewardValues()).containsExactlyInAnyOrder("KARAOKE PRO MICROPHONE", "CHAMPIONS LEAGUE FINAL TICKET", "PIRATES OF THE CARIBBEAN COLLECTION");
    }

    @Test
    public void givenAnIneligibleAccountThenReturnsAMessage() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {"KIDS", "MUSIC", "SPORTS", "NEWS", "MOVIES"};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(8);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenReturn(CustomerEligiblityValue.CUSTOMER_INELIGIBLE);
        Reward reward = rewardService.getRewards(1, portfolio);
        assertThat(reward).isNotNull();
        assertThat(reward.getAccount()).isEqualTo(1);
        assertThat(reward.getMessage()).isEqualTo("Customer is not eligible for Rewards");
        assertThat(reward.isSuccess()).isFalse();
        assertThat(reward.getRewardValues()).isEmpty();
    }

    @Test(expected = InvalidChannelException.class)
    public void givenInvalidChannelsThenReturnsAException() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {"FASHION", "BUSINESS", "GEOGRAPHY", "HISTORY"};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(1);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenReturn(CustomerEligiblityValue.CUSTOMER_ELIGIBLE);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void givenInvalidAccountThenReturnsAException() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {"KIDS"};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(1);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenThrow(new InvalidAccountNumberException("Account 1 is not right"));
        Reward reward = rewardService.getRewards(1, portfolio);
    }

    @Test(expected = InvalidChannelException.class)
    public void givenNoChannelsThenReturnsAException() throws InvalidChannelException, InvalidAccountNumberException {
        ChannelSubscriptions channelSubscriptions = new ChannelSubscriptions();
        String[] channels = {};
        channelSubscriptions.setChannels(channels);
        channelSubscriptions.setAccountid(1);
        Portfolio portfolio = new Portfolio(channelSubscriptions);
        when(eligibilityService.getCustomerEligibility(1)).thenReturn(CustomerEligiblityValue.CUSTOMER_ELIGIBLE);
        Reward reward = rewardService.getRewards(1, portfolio);
    }
}

