package com.example.building_rest_02;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.concurrent.atomic.AtomicLong;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public Quote() {
        setDefaults();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    private void setDefaults() {
        AtomicLong counter = new AtomicLong();
        this.type = "Test Type Wonderlabz";
        value = new Value();
        value.setId(counter.incrementAndGet());
        value.setQuote("Fortune favours the fearless");
    }

    @Override
    public String toString() {
        return "Quote{" + "type='" + type + '\'' + ", value=" + value + '}';
    }
}
