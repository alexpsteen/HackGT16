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

public class FitnessDB extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "fitness.db";
    private static final String TABLE_FITNESS = "fitness";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_REPS = "reps";
    private static final String COLUMN_SETS = "sets";
    private static final String COLUMN_STARTTIME= "start_time";
    private static final String COLUMN_ENDTIME = "end_time";
    private static final String COLUMN_STEPCOUNTER = "step_counter";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_LIST_ID = "list_id";
    private static final String COLUMN_ISCOMPLETED = "isCompleted";
    private String username;


    public FitnessDB(Context context, String username) {
        super(context, DATABASE_NAME, null, 1);
        this.username = username;
    }


    public void onCreate(SQLiteDatabase db) {
        //This creates all of the columns in our table followed by their data
        // type with a boolean represented as an integer that is either 1 or 0
        String query = "CREATE TABLE " + this.username + "-" +TABLE_FITNESS + " ("
                + COLUMN_NAME + " TEXT, "
                + COLUMN_TYPE + " TEXT, "
                + COLUMN_REPS + " INTEGER, "
                + COLUMN_SETS + " INTEGER, "
                + COLUMN_STARTTIME + " TEXT, "
                + COLUMN_ENDTIME + " TEXT,"
                + COLUMN_STEPCOUNTER + " INTEGER,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_LIST_ID + "TEXT,"
                + COLUMN_ISCOMPLETED + "INTEGER"
                + ");";

        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP_TABLE_IF_EXISTS " + this.username+"-"+TABLE_FITNESS);
        onCreate(db);
    }

    public void addExercise(String exerciseName, String type, int reps,int sets, String listID) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();Cursor c = db.rawQuery("SELECT * FROM " + this.username + "-" + TABLE_FITNESS+ " WHERE " + COLUMN_LIST_ID + " = '" + listID +"';", null);
        c.moveToFirst();
        if (c.isBeforeFirst()) {
            values.put(COLUMN_NAME, exerciseName);
            values.put(COLUMN_TYPE, type);
            values.put(COLUMN_REPS, reps);
            values.put(COLUMN_SETS, sets);
            values.put(COLUMN_STARTTIME,"");
            values.put(COLUMN_ENDTIME, "");
            values.put(COLUMN_STEPCOUNTER, 0);
            values.put(COLUMN_DATE, "");
            values.put(COLUMN_LIST_ID, listID);
            values.put(COLUMN_ISCOMPLETED, 0);
            db.insert(this.username + "-"+TABLE_FITNESS, null, values);
        }
        c.close();
        db.close();
    }

    public LinkedList<exerciseEntry> getEntries(String listID) {
        LinkedList<exerciseEntry> entries = new LinkedList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + this.username + "-" + TABLE_FITNESS + " WHERE "
                + COLUMN_LIST_ID + " = '" + listID + "';", null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            entries.add(new exerciseEntry(c.getString(c.getColumnIndex(COLUMN_NAME)), c.getInt(c.getColumnIndex(COLUMN_SETS)),
                    c.getInt(c.getColumnIndex(COLUMN_REPS))));
            c.moveToNext();
        }
        c.close();
        db.close();
        return entries;
    }

    public LinkedList<Elist> getELists() {
        LinkedList<Elist> eLists = new LinkedList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + this.username + "-" + TABLE_FITNESS + ";",null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            String id = c.getString(c.getColumnIndex(COLUMN_LIST_ID));
            if(!eLists.contains(id)) {
                eLists.add(new Elist(id));
            }
            c.moveToNext();
        }
        c.close();
        db.close();
        return eLists;
    }

    public boolean isCompleted(String listID, String name) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + this.username + "-" + TABLE_FITNESS + "WHERE"
                + COLUMN_LIST_ID + " = '" + listID + "' AND " + COLUMN_NAME + " = '"
                + name + "';",null);
        c.moveToFirst();
        int num = c.getInt(c.getColumnIndex(COLUMN_ISCOMPLETED));
        if(num == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void changeSets(String listID, String name, int newSet) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETS, newSet);
        db.update(this.username + "-" + TABLE_FITNESS, values,COLUMN_LIST_ID + " = '" + listID + "' AND " + COLUMN_NAME + " = '"
                + name + "';" , null);
        db.close();
    }

    public void changeReps(String listID, String name, int newRep) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETS, newRep);
        db.update(this.username + "-" + TABLE_FITNESS, values,COLUMN_LIST_ID + " = '" + listID + "' AND " + COLUMN_NAME + " = '"
                + name + "';" , null);
        db.close();
    }

    public void changeIsCompleted(String listID, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ISCOMPLETED, 1);
        db.update(this.username + "-" + TABLE_FITNESS, values,COLUMN_LIST_ID + " = '" + listID + "' AND " + COLUMN_NAME + " = '"
                + name + "';" , null);
        db.close();
    }
}
