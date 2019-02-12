package com.example.usager.projet_android_matthew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String COL_ID = "ID";

    private static final String CREATE_BDD = "CREATE TABLE " + "user" + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "username" + " TEXT NOT NULL, "
            + "nom" + " TEXT NOT NULL," + "password" + " TEXT NOT NULL);";
    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
//comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + "user" + ";");
        onCreate(db);
    }
}

