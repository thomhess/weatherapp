package com.androstock.myweatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thomhess on 19.09.16.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data.db";
    private static final String TABLE_DATA = "WeatherHistory";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_UPDATEDON = "updatedOn";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_ALTITUDE = "altitude";
    private static final String COLUMN_TEMPERATURE = "temperature";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_DATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_LOCATION + " TEXT " +
                COLUMN_UPDATEDON + " TEXT " +
                COLUMN_LATITUDE + " FLOAT " +
                COLUMN_LONGITUDE + " FLOAT " +
                COLUMN_ALTITUDE + " FLOAT " +
                COLUMN_TEMPERATURE + " FLOAT " +
                ");";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        onCreate(db);
    }

    //Add new row to table
    public void addRow(WeatherData weatherInfo) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOCATION, weatherInfo.get_location());
        values.put(COLUMN_LATITUDE, weatherInfo.get_latitude());
        values.put(COLUMN_LONGITUDE,weatherInfo.get_longitude());
        values.put(COLUMN_ALTITUDE, weatherInfo.get_altitude());
        values.put(COLUMN_UPDATEDON, weatherInfo.get_updatedOn());
        values.put(COLUMN_TEMPERATURE, weatherInfo.get_temperature());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DATA, null, values);
        db.close();
    }

    // Delete from database
    public void deleteRow(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL( "DELETE FROM" + TABLE_DATA + " WHERE " + COLUMN_LOCATION + "=\"" + productName + "\";" );
    }

    //Print out the database as a string
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DATA + " WHERE 1";

        // Cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("location"))!= null) {
                dbString += c.getString(c.getColumnIndex("location"));
                dbString += "\n";
            }

        }
        db.close();
        return dbString;
    }
}
