package com.example.alexsteen.hackgt16;

/**
 * Created by ericachia on 9/24/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class userDB extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ISCONSULTANT = "isConsultant";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_AGE = "age";

    public userDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + " ("
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_ISCONSULTANT + " INTEGER, "
                + COLUMN_HEIGHT + " DOUBLE, "
                + COLUMN_WEIGHT + " INTEGER, "
                + COLUMN_AGE + " INTEGER "
                + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP_TABLE_IF_EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public boolean addUser(User user) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + user.getUsername() + "';", null);
        c.moveToFirst();
        if (c.isBeforeFirst()) {
            values.put(COLUMN_USERNAME, user.getUsername());
            values.put(COLUMN_PASSWORD, user.getPassword());
            values.put(COLUMN_NAME, user.getName());
            values.put(COLUMN_ISCONSULTANT, user.getIsConsultant());
            values.put(COLUMN_HEIGHT, user.getHeight());
            values.put(COLUMN_WEIGHT, user.getWeight());
            values.put(COLUMN_AGE, user.getAge());
            db.insert(TABLE_USERS, null, values);
        } else {
            return false;
        }
        c.close();
        db.close();
        return true;
    }

    public boolean containsUsername(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "';", null);
        c.moveToFirst();
        if(c.isBeforeFirst()){
            return false;
        }
        c.close();
        return true;
    }

    public boolean authenticateUser(String username, String password) throws Exception {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "';", null);
        c.moveToFirst();
        String realPassword;
        if (!c.isBeforeFirst()) {
            realPassword = c.getString(c.getColumnIndex(COLUMN_PASSWORD));
        } else {
            return false;
        }
        c.close();
        db.close();
        System.out.println("Real PW: " + realPassword);
        return realPassword.equals(password);
    }

    public String getName(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "';", null);
        c.moveToFirst();
        String name = c.getString(c.getColumnIndex(COLUMN_NAME));
        c.close();
        db.close();
        return name;
    }

    public boolean isConsultant(String username) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + username + "';", null);
        c.moveToFirst();
        int isConsultant = c.getInt(c.getColumnIndex(COLUMN_ISCONSULTANT));
        if(isConsultant == 0) {
            return false;
        } else {
            return true;
        }
    }
}
