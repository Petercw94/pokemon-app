package com.peterwilliams.pokemon;

public enum PokeOptions
{
    
    CHARIZARD (1, "charizard"),
    PIKACHU (2, "pikachu"),
    SQUIRTLE (3, "squirtle"),
    DITTO (4, "ditto");

    // class variables
    private final int option;
    private final String name;

    PokeOptions(int option, String name)
    {
        this.option = option;
        this.name = name;
    }

    // getters
    public int option() { return option; }
    public String pokemonName() { return name; }
    
}
