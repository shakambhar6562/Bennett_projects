package com.example.eyes;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHandler extends SQLiteOpenHelper {

    private  static final int databaseVersion=1;
    private static final String databaseName="android_api";
    private static final String android_api="Login";
    private static final String keypass="pass",keyemail="email";
    public SqlHandler(Context context)
    {
        super(context,databaseName,null,databaseVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createLoginTable="CREATE TABLE "+ android_api+ "("+keypass+"TEXT, "+
                keyemail+"TEXT Unique"+ ")";
        db.execSQL(createLoginTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+android_api);
        onCreate(db);
    }
    public void addUser(String email,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(keyemail,email);
        values.put(keypass,pass);
        db.insert(android_api,null,values);
        db.close();
    }
}
