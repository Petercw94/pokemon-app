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

            // getting the user input for the desired pokemon
            Scanner input = new Scanner(System.in);
            
            System.out.println("Please select a pokemon for battle: ");
            System.out.println("1. Charizard");
            System.out.println("2. Pikachu");
            System.out.println("3. Squirtle");
            System.out.println("4. Ditto");
            
            int choice = input.nextInt();
            input.close(); // close the scanner object

            PokeOptions pokeChoice = PokeOptions.values()[choice-1];
            System.out.println("\nLooks like you chose: " + pokeChoice.pokemonName() + ".");

            URLConnection con = new URL(String.format("https://pokeapi.co/api/v2/pokemon/%s", pokeChoice.pokemonName())).openConnection();
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            con.setRequestProperty("Accept-Charset", charset);
            InputStream response = con.getInputStream();
            // con.close();
            JSONParser parser = new JSONParser();
            JSONObject resposneJSON = (JSONObject) parser.parse(new InputStreamReader(response, "UTF-8"));

            // System.out.println(resposneJSON);
            Pokemon poke = new Pokemon(resposneJSON);
            System.out.println("Name: " + poke.getName());

             
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



