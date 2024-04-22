package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase extends SQLiteOpenHelper {
    static final String dbName = "dbName";
    static final int Version = 1;
    static final String tableau = "Personne";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String FAMILYNAME = "familyName";
    public static final String Email = "email";
    public static final String Phone = "phone";
    public DataBase(Context context) {
        super(context, dbName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableau+"("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NAME + " TEXT NOT NULL,"+
                FAMILYNAME + " TEXT NOT NULL,"+
                Email + " TEXT NOT NULL," +
                Phone + " TEXT NOT NULL"+
                ");");

    }
    public void createProfile(String name, String familyName, String email, String phone){
        SQLiteDatabase database = this.getWritableDatabase(); //calling the DB
        ContentValues Cleandb = new ContentValues(); // call the content

        Cleandb.put(DataBase.NAME, name);
        Cleandb.put(DataBase.FAMILYNAME, familyName);
        Cleandb.put(DataBase.Email, email);
        Cleandb.put(DataBase.Phone, phone);


        database.insert(DataBase.tableau, null, Cleandb);
    }
    //public ArrayList<HashMap<String, Object>> FindAllProfile(){}
    public void updateProfile(String Id, String name, String familyName, String email, String phone){
        SQLiteDatabase database = this.getWritableDatabase(); //calling the DB
        ContentValues Cleandb = new ContentValues(); // call the content

        Cleandb.put(DataBase.NAME, name);
        Cleandb.put(DataBase.FAMILYNAME, familyName);
        Cleandb.put(DataBase.Email, email);
        Cleandb.put(DataBase.Phone, phone);


        database.update(DataBase.tableau, Cleandb, DataBase.ID+" = ?",new String[]{Id});
    }

    public ArrayList<Donut> getUsers(){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<Donut> userList = new ArrayList<>();
        String query = "SELECT * FROM "+ tableau +" ;";
        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToNext()){
            Donut user =new Donut();

            user.setID(cursor.getString(cursor.getColumnIndex(ID)));
            user.setNAME(cursor.getString(cursor.getColumnIndex(NAME)));
            user.setFAMILYNAME(cursor.getString(cursor.getColumnIndex(FAMILYNAME)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(Email)));
            user.setPhone(cursor.getString(cursor.getColumnIndex(Phone)));

            userList.add(user);
        }
        return userList;
    }
    public void deleteProfile(String id) {
        SQLiteDatabase database = this.getWritableDatabase();

        // Specify the where clause
        String selection = DataBase.ID + " = ?";

        // Specify arguments in the where clause
        String[] selectionArgs = {id};

        // Delete the row
        database.delete(DataBase.tableau, selection, selectionArgs);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
