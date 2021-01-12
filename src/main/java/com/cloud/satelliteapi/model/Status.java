package com.cloud.satelliteapi.model;

public enum Status {
    ATTACHED("attached"),
    DETACHED("detached");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
