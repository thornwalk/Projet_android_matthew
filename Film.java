package com.example.usager.projet_android_matthew;

public class Film {

    private int _id;
    private String nomFilm;
    private String genre;

    public Film(){}
    public Film(String nomFilm, String genre)
    {
        this.nomFilm = nomFilm;
        this.genre = genre;
    }

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        this._id = id;
    }

    public String getFilm()
    {
        return nomFilm;
    }

    public void setFilm(String film)
    {
        this.nomFilm = film;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genreFilm)
    {
        this.genre = genreFilm;
    }

    public String toString()
    {
        return "Voici le ID : " + _id + ", le nom du film est " + nomFilm + " et le genre " + genre;
    }
}
