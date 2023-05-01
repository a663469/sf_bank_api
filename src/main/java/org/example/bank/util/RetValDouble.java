package org.example.bank.util;

public class RetValDouble {
    private double value;
    private String message;

    public RetValDouble() {
    }

    public RetValDouble(double value, String message) {
        this.value = value;
        this.message = message;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RetValDouble{" +
                "value=" + value +
                ", message='" + message + '\'' +
                '}';
    }
}
