package com.sky.rewards;

import com.sky.rewards.service.impl.SkyEligibilityService;
import com.sky.rewards.value.CustomerEligiblityValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rajesh on 20-May-17.
 */
public class SkyEligibilityServiceTest {
    @Test
    public void givenEligibleAccountThenReturnCustomerEligible() throws InvalidAccountNumberException {
        SkyEligibilityService skyEligibilityService = new SkyEligibilityService();
        assertThat(skyEligibilityService.getCustomerEligibility(1)).isEqualTo(CustomerEligiblityValue.CUSTOMER_ELIGIBLE);
    }

    @Test
    public void givenAnInEligibleAccountThenReturnCustomerInEligible() throws InvalidAccountNumberException {
        SkyEligibilityService skyEligibilityService = new SkyEligibilityService();
        assertThat(skyEligibilityService.getCustomerEligibility(6)).isEqualTo(CustomerEligiblityValue.CUSTOMER_INELIGIBLE);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void givenAnUnknownAccountThenThrowException() throws InvalidAccountNumberException {
        SkyEligibilityService skyEligibilityService = new SkyEligibilityService();
        skyEligibilityService.getCustomerEligibility(60);
    }

    public void givenAValidAccountReturnsTrue() {
        SkyEligibilityService skyEligibilityService = new SkyEligibilityService();
        assertThat(skyEligibilityService.isValidAccount(1)).isTrue();
    }

    public void givenAnInValidAccountReturnsFalse() {
        SkyEligibilityService skyEligibilityService = new SkyEligibilityService();
        assertThat(skyEligibilityService.isValidAccount(7)).isFalse();
    }
}
