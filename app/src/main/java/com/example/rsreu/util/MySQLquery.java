package com.example.rsreu.util;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rsreu.data.DatabaseHelper;
import com.example.rsreu.data.json_parser.api.source.subsource.Denominator;
import com.example.rsreu.data.json_parser.api.source.subsource.Numerator;
import com.example.rsreu.data.json_parser.api.source.subsource.Settings;
import com.example.rsreu.data.json_parser.api.source.subsource.Times;

import java.io.IOException;
import java.util.ArrayList;

public class MySQLquery {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private ArrayList<Settings> settingsData = new ArrayList<>();
    private ArrayList<Times> timesArrayList=new ArrayList<>();
    private ArrayList<Denominator> denominators=new ArrayList<>();
    private ArrayList<Numerator> numerators=new ArrayList<>();
    //    "SELECT * FROM numerator WHERE groupName=\""+group+"\"" +
//            " AND weekDay="+weekDay+" AND(dates="+dates+" OR dates=0)"
    public MySQLquery(DatabaseHelper databaseHelper) {
        this.databaseHelper=databaseHelper;
        try{
            this.databaseHelper.updateDataBase();
        } catch (IOException e) {
            throw new Error("UnableToUpdateDatabase");
        }
        try{
            this.database=databaseHelper.getWritableDatabase();
        }catch (SQLException e){
            throw e;
        }
    }
    public ArrayList<Settings> getSettings(){
        Cursor cursor=database.rawQuery("SELECT * FROM settings",null);
        cursor.moveToFirst();
        Settings settings = new Settings();
        settings.setStartDate(cursor.getString(0));
        settings.setEndDate(cursor.getString(1));
        settings.setNumerator(cursor.getString(2));
        settingsData.add(settings);
        cursor.close();
        return settingsData;
    }
    public ArrayList<Times> getTimes(){
        Cursor cursor=database.rawQuery("SELECT * FROM times",null);
        cursor.moveToFirst();
        for (int i=0;!cursor.isAfterLast();i++){
            Times times =new Times();
            times.setId(cursor.getInt(0));
            Log.e("TIME", String.valueOf(cursor.getInt(0)));
            times.setFrom(cursor.getString(1));
            times.setTo(cursor.getString(2));
            Log.e("FROM",cursor.getString(1));
            cursor.moveToNext();
            timesArrayList.add(i,times);

        }
        cursor.close();
        return timesArrayList;
    }
    public ArrayList<Denominator>getDenominators(String group,int weekDay,String dates){
        Cursor cursor=database.rawQuery("SELECT * FROM denominator" +
                " WHERE Name="+group+" AND weekDay="+weekDay+" AND(dates="+dates+" OR dates=0)",null);
        cursor.moveToFirst();
        for (int i=0;!cursor.isAfterLast();i++){
            Denominator denominator=new Denominator();
            //denominator.setWeekDay(cursor.getInt(1));
            denominator.setTimeId(cursor.getInt(2));
            denominator.setDuration(cursor.getInt(3));
            denominator.setTitle(cursor.getString(4));
            denominator.setType(cursor.getString(5));
            denominator.setOptional(cursor.getInt(6));
            denominator.setTeachers(cursor.getString(7));
            denominator.setRoom(cursor.getString(8));
            denominator.setBuild(cursor.getString(9));
            denominator.setDates(cursor.getString(10));
            cursor.moveToNext();
            denominators.add(i,denominator);
        }
        cursor.close();
        return denominators;
    }
    public ArrayList<Numerator>getNumerators(String group,int weekDay,String dates){
//        Cursor cursor=database.rawQuery("SELECT * FROM numerator" +
//                " WHERE Name="+group+" AND weekDay="+weekDay+" AND(dates="+dates+" OR dates=0)",null);
        Cursor cursor=database.rawQuery("SELECT * FROM numerator" +
                " WHERE Name="+group+" AND weekday="+weekDay+" AND(dates="+dates+" OR dates=0)",null);
        cursor.moveToFirst();
        for (int i=0;!cursor.isAfterLast();i++){
            Numerator numerator=new Numerator();
            //denominator.setWeekDay(cursor.getInt(1));
            numerator.setTimeId(cursor.getInt(2));
            numerator.setDuration(cursor.getInt(3));
            numerator.setTitle(cursor.getString(4));
            numerator.setType(cursor.getString(5));
            numerator.setOptional(cursor.getInt(6));
            numerator.setTeachers(cursor.getString(7));
            numerator.setRoom(cursor.getString(8));
            numerator.setBuild(cursor.getString(9));
            numerator.setDates(cursor.getString(10));
            cursor.moveToNext();
            numerators.add(i,numerator);
        }
        cursor.close();
        return numerators;
    }
}