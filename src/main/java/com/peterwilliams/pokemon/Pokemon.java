package com.peterwilliams.pokemon;

import org.json.simple.JSONObject;

public class Pokemon {
    private String name;
    private long height;
    private long weight;
    private long baseExperience;
    private String frontSprite;
    private String backSprite;

    public Pokemon(JSONObject json)
    {
        this.name = (String) json.get("name");
        this.height = (long) json.get("height");
        this.weight = (long) json.get("weight");
        this.baseExperience = (long) json.get("base_experience");
        // accessing the sprite layer
        JSONObject sprites = (JSONObject) json.get("sprites");
        this.frontSprite = (String) sprites.get("front_default");
        this.backSprite = (String) sprites.get("back_default");
    }

    public String getName()
    {
        return name;
    }

    public long getHeight()
    {
        return height;
    }

    public long getWeight()
    {
        return weight;
    }

    public long getBaseExperience()
    {
        return baseExperience;
    }

    public String getFrontSprite()
    {
        return frontSprite;
    }
}
