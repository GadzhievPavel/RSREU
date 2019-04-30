package com.example.rsreu.data;//package com.example.rseru.data;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//import com.example.rseru.data.json_parser.api.source.subsource.Denominator;
//import com.example.rseru.data.json_parser.api.source.subsource.Numerator;
//import com.example.rseru.data.json_parser.api.source.subsource.Settings;
//import com.example.rseru.data.json_parser.api.source.subsource.Times;
//
//import java.util.ArrayList;
//
//public class ConnectorLocalDB {
//    private SQLiteDatabase database;
//    public ConnectorLocalDB(Context context){
//        LocalDBHelper dbHelper=new LocalDBHelper(context);
//        database=dbHelper.getWritableDatabase();
//        dbHelper.onCreate(database);
//
//
//    }
//    public void insert(Times times){
//        ContentValues values=new ContentValues();
//        values.put(LocalDBHelper.FROM,times.getFrom());
//        values.put(LocalDBHelper.TO,times.getTo());
//        values.put(LocalDBHelper.ID,times.getId());
//        database.insert(LocalDBHelper.TIMES_TABLE,null,values);
//
//    }
//    public void insert(Numerator numerator,String group){
//        ContentValues values=new ContentValues();
//        values.put(LocalDBHelper.NUMBER_GROUP,group);
//        values.put(LocalDBHelper.WEEKDAY,numerator.getWeekDay());
//        values.put(LocalDBHelper.TIME_ID,numerator.getTimeId());
//        values.put(LocalDBHelper.DURATION,numerator.getDuration());
//        values.put(LocalDBHelper.TITLE,numerator.getTitle());
//        values.put(LocalDBHelper.TYPE,numerator.getType());
//        values.put(LocalDBHelper.TEACHERS,numerator.getTeachers());
//        values.put(LocalDBHelper.ROOM,numerator.getRoom());
//        values.put(LocalDBHelper.BUILD,numerator.getBuild());
//        values.put(LocalDBHelper.DATES,numerator.getDates());
//        values.put(LocalDBHelper.OPTIONAL,numerator.getOptional());
//        database.insert(LocalDBHelper.NUMERATOR_TABLE,null,values);
//
//    }
//    public void insert(Denominator denominator,String group){
//        ContentValues values=new ContentValues();
//        values.put(LocalDBHelper.NUMBER_GROUP,group);
//        values.put(LocalDBHelper.WEEKDAY,denominator.getWeekDay());
//        values.put(LocalDBHelper.TIME_ID,denominator.getTimeId());
//        values.put(LocalDBHelper.DURATION,denominator.getDuration());
//        values.put(LocalDBHelper.TITLE,denominator.getTitle());
//        values.put(LocalDBHelper.TYPE,denominator.getType());
//        values.put(LocalDBHelper.TEACHERS,denominator.getTeachers());
//        values.put(LocalDBHelper.ROOM,denominator.getRoom());
//        values.put(LocalDBHelper.BUILD,denominator.getBuild());
//        values.put(LocalDBHelper.DATES,denominator.getDates());
//        values.put(LocalDBHelper.OPTIONAL,denominator.getOptional());
//        database.insert(LocalDBHelper.DENOMINATOR_TABLE,null,values);
//    }
//    public void insert(Settings settings){
//        ContentValues values=new ContentValues();
//        values.put(LocalDBHelper.START_DATE,settings.getStartDate());
//        values.put(LocalDBHelper.END_DATE,settings.getEndDate());
//        values.put(LocalDBHelper.IS_NUMERATOR,settings.isNumerator());
//        database.insert(LocalDBHelper.SETTINGS_TABLE,null,values);
//    }
//    public ArrayList<String> find() {
//        ArrayList<String> list = null;
//        Cursor cursor=database.rawQuery("SELECT * FROM "+LocalDBHelper.SETTINGS_TABLE,null);
//        if(cursor!=null) {
//            cursor.moveToFirst();
//            for (int i = 0; cursor.isAfterLast(); i++) {
//                list.add(cursor.getString(0));
//            }
//            cursor.close();
//        }
//        else
//            Log.e("CURSOR","ISNULL");
//        return list;
//    }
//}
