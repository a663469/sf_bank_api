package org.example.bank.util;

public class RetValBool {
    private boolean value;
    private String message;

    public RetValBool() {
    }

    public RetValBool(boolean value, String message) {
        this.value = value;
        this.message = message;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
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
        return "RetValBool{" +
                "value=" + value +
                ", message='" + message + '\'' +
                '}';
    }
}
