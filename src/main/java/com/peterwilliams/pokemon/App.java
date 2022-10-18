package com.peterwilliams.pokemon;

import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;



public class App 
{
    public static void main( String[] args )
    {
        // benchmark the execution time:
        long startTime = System.currentTimeMillis();
        // create an instance of the URL class

         // create an instance of the HTTP connection class
        // 1. The connection object is created by invoking the openConnection method on a URL.
        // 2. The setup parameters and general request properties are manipulated.
        // 3. The actual connection to the remote object is made, using the connect method.
        // 4. The remote object becomes available. The header fields and the contents of the remote object can be accessed.
        // URLConnection con = url.openConnection();
        try {
            URLConnection con = new URL("https://pokeapi.co/api/v2/pokemon/charizard").openConnection();
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            con.setRequestProperty("Accept-Charset", charset);
            InputStream response = con.getInputStream();
            // con.close();
            JSONParser parser = new JSONParser();
            JSONObject resposneJSON = (JSONObject) parser.parse(new InputStreamReader(response, "UTF-8"));

            // System.out.println(resposneJSON);
            Pokemon poke = new Pokemon(resposneJSON);
            System.out.println("Name: " + poke.getName());
            System.out.println("Height: " + poke.getHeight() + " | Weight: " + poke.getWeight());
            System.out.println("Base Experience: " + poke.getBaseExperience());
            System.out.println("Front Sprite: " + poke.getFrontSprite());

             
        } catch(MalformedURLException ex) {
            System.out.println("MalformedURLException: " + ex);
        } catch(IOException ex) {
            System.out.println("IOException: " + ex);
        } catch(ParseException ex) {
            System.out.println("ParseException: " + ex);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
       
    }
};

class Pokemon 
{
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

