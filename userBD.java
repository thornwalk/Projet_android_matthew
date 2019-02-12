package com.example.usager.projet_android_matthew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class userBD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "laby.db";
    private static final String TABLE_LIVRES = "user";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_user= "username";
    private static final int NUM_COL_user = 1;
    private static final String COL_nom = "nom";
    private static final int NUM_COL_nom = 2;
    private static final String COL_pass = "password";
    private static final int NUM_COL_pass = 2;
    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;
    public userBD(Context context){
//On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }
    public void open(){
//on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }
    public void close(){
//on ferme l'accès à la BDD
        bdd.close();
    }
    public SQLiteDatabase getBDD(){
        return bdd;
    }
    public long insertLivre(User user){
//Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
//on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_user, user.getUsername());
        values.put(COL_nom, user.getNom());
//on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_LIVRES, null, values);
    }
    public int updateLivre(int id, User user){
//La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
//il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_user, user.getUsername());
        values.put(COL_nom, user.getNom());
        return bdd.update(TABLE_LIVRES, values, COL_ID + " = " +id, null);
    }
    public int removeLivreWithID(int id){
//Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_LIVRES, COL_ID + " = " +id, null);
    }
    public User getLivreWithTitre(String titre){
//Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_user, COL_nom},
                COL_nom + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToUser(c);
    }
    //Cette méthode permet de convertir un cursor en un livre
    private User cursorToUser(Cursor c){
//si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();
//On créé un livre
        User livre = new User();
//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        livre.setId(c.getInt(NUM_COL_ID));
        livre.setUsername(c.getString(NUM_COL_user));
        livre.setNom(c.getString(NUM_COL_nom));
//On ferme le cursor
        c.close();
//On retourne le livre
        return livre;
    }

}
