package com.example.rsreu.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class LocalDBHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private SQLiteDatabase mDataBase;
    private boolean mNeedUpdate = false;

    static final String DB_NAME="localDB";
    static int VERSION=3;
    static final String _ID="_id";

    //tabel SETTINGS
    public final String SETTINGS_TABLE="'settings'";
    public final String START_DATE="'startDate'";
    public final String END_DATE="'endDate'";
    public final String IS_NUMERATOR="'isNumerator11'";
    //tabel TIMES
    public final String TIMES_TABLE="'table'";
    public final String ID="'id'";
    public final String FROM="'from'";
    public final String TO="'to'";
    //tabels timeLine
    public final String NUMERATOR_TABLE="'numerator'";
    public final String DENOMINATOR_TABLE="'denominator'";
    public final String NUMBER_GROUP="'gpoup'";
    public final String WEEKDAY="'weekday'";
    public final String TIME_ID="'timeId'";
    public final String DURATION="'duration'";
    public final String TITLE="'title'";
    public final String TYPE="'type'";
    public final String OPTIONAL="'optional'";
    public final String TEACHERS="'teachers'";
    public final String ROOM="'room'";
    public final String BUILD="'build'";
    public final String DATES="'dates'";
    private final String createTimeLine="("+_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
            +NUMBER_GROUP+" TEXT NOT NULL,"+WEEKDAY+" INTEGER NOT NULL,"+TIME_ID+" INTEGER NOT NULL,"+
            DURATION+" INTEGER NOT NULL,"+TITLE+" TEXT NOT NULL,"+TYPE+" TEXT NOT NULL,"+
            TEACHERS+" TEXT,"+ROOM+" TEXT,"+BUILD+" TEXT NOT NULL,"+
            DATES+" TEXT,"+OPTIONAL+" TEXT NOT NULL)";

    public LocalDBHelper(Context context) {
        super(context, DB_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS "+SETTINGS_TABLE+"("+_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                    +START_DATE+" TEXT NOT NULL,"+END_DATE+
                    " TEXT NOT NULL, "+IS_NUMERATOR+" TEXT NOT NULL)");
//            db.execSQL("CREATE TABLE "+TIMES_TABLE+"("+_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
//                    +ID+" INTEGER NOT NULL,"+FROM+" TEXT NOT NULL,"+
//                    TO+" TEXT NOT NULL)");
//            db.execSQL("CREATE TABLE "+NUMERATOR_TABLE+createTimeLine);
//            db.execSQL("CREATE TABLE "+DENOMINATOR_TABLE+createTimeLine);
            Log.e("CREATE DB","IS_GOOD");
        }catch (SQLException e){
            Log.e("SETCREAT","FAIL");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +SETTINGS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " +DENOMINATOR_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " +NUMERATOR_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " +TIMES_TABLE);
        onCreate(db);
    }

}
