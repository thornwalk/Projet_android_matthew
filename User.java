package com.example.usager.projet_android_matthew;

public class User {
    private int _id;
    private String username;
    private String nom;
    private String password;

    public void setId(int id)
    {
        this._id = id;
    }

    public void setUsername(String name)
    {
        this.username = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setNom(String name)
    {
        this.nom = name;
    }

    public String getNom()
    {
        return nom;
    }

    public void setPassword(String pass)
    {
        this.password = pass;
    }

    public String getPassword()
    {
        return password;
    }

    public String toString()
    {
        return "Bienvenue " + username + " dans le jeu de labyrinthe";
    }
}
