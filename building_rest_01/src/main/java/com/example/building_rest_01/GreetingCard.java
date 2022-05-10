package com.example.building_rest_01;

public class GreetingCard {
    private final long id;
    private final String name;
    private final String content;

    /**
     * GreetingCard constructor
     * @param id
     * @param name
     * @param content
     */
    public GreetingCard(long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }
}
