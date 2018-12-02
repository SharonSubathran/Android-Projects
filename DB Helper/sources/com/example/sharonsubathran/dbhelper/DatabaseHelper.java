package com.example.sharonsubathran.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table student_table (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS student_table");
        onCreate(sQLiteDatabase);
    }

    public boolean insertData(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, str);
        contentValues.put(COL_3, str2);
        contentValues.put(COL_4, str3);
        return writableDatabase.insert(TABLE_NAME, null, contentValues) == -1 ? null : true;
    }

    public Cursor getAllData() {
        return getWritableDatabase().rawQuery("select * from student_table", null);
    }

    public boolean updateData(String str, String str2, String str3, String str4) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, str);
        contentValues.put(COL_2, str2);
        contentValues.put(COL_3, str3);
        contentValues.put(COL_4, str4);
        writableDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[]{str});
        return true;
    }

    public Integer deleteData(String str) {
        return Integer.valueOf(getWritableDatabase().delete(TABLE_NAME, "ID = ?", new String[]{str}));
    }
}
