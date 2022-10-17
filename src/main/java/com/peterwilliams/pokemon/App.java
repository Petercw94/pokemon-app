package com.peterwilliams.pokemon;

import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


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
            
            ObjectMapper mapper = new ObjectMapper();
            Pokemon poke = mapper.readValue(response, Pokemon.class)


             
        } catch(MalformedURLException ex) {
            System.out.println("MalformedURLException: " + ex);
        } catch(IOException ex) {
            System.out.println("IOException: " + ex);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
       
    }
};

class Pokemon 
{
    private String name;
    private Integer height;
    private Integer weight;
    private Integer baseExperience;
    // private URL frontSprite;
    // private URL backSprite;

    public Pokemon(String name, Integer height, Integer baseExperience)
    {
        this.name = name;
        this.height = height;
        this.baseExperience = baseExperience;
    }

    public String getName()
    {
        return name;
    }

    public int[] getHeightAndWeight()
    {
        return new int[] {height, weight};
    }

    public Integer getBaseExperience()
    {
        return baseExperience;
    }
}

