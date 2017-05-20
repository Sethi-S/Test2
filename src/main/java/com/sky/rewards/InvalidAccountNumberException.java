package com.sky.rewards;

/**
 * Created by Rajesh on 20-May-17.
 */
public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}
