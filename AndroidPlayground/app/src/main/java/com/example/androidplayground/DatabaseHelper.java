package com.example.androidplayground;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student";
    public static final String TABLE_NAME = "student_tbl";

    /**
     * Table fields
     * student_tbl
     */
    public static final String ID_FIELD = "id";
    public static final String FIRST_NAME_FIELD = "firstname";
    public static final String LAST_NAME_FIELD = "lastname";
    public static final String REMARKS_FIELD = "remarks";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                ""+ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                ""+FIRST_NAME_FIELD+" TEXT," +
                ""+LAST_NAME_FIELD+" TEXT," +
                ""+REMARKS_FIELD+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean insertData(String firstName, String lastName, String remarks) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME_FIELD, firstName);
        contentValues.put(LAST_NAME_FIELD, lastName);
        contentValues.put(REMARKS_FIELD, remarks);

        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();

        // checks whether data is successfully inserted
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return result;
    }
}
