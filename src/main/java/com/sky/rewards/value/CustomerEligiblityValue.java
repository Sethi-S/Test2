package com.sky.rewards.value;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CustomerEligiblityValue {

    CUSTOMER_ELIGIBLE(1, "Customer Elgible"),
    CUSTOMER_INELIGIBLE(2, "Customer not elgible"),;

    private static final Map<Integer, CustomerEligiblityValue> lookupByResultCode = new HashMap<Integer, CustomerEligiblityValue>();

    static {
        for (CustomerEligiblityValue s : EnumSet.allOf(CustomerEligiblityValue.class)) {
            lookupByResultCode.put(s.getCode(), s);
        }
    }

    private Integer code;
    private String description;


    private CustomerEligiblityValue(Integer code, String description) {
        this.code = code;
        this.description = description;
    }


    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


}
