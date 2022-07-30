package com.example.sqlitedb_test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class My_database extends SQLiteOpenHelper {

     public static final String DataBase_NAME ="cars" ;
     public static final String  TABLE_NAME="car" ;

     public static final int DB_VERSION = 1 ;

     public static final String COL_COLOr = "color";
     public static final String  COL_id ="id";
     public static final String COL_MODEL = "model";
     public static final String COL_IMAGE="image" ;

      Context c ;
      public My_database(Context c ) {
        super(c, DataBase_NAME,null,DB_VERSION);
         this.c = c ;
     }
     @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

          sqLiteDatabase.execSQL("Create Table "+ TABLE_NAME +" ( "+COL_id +" INTEGER primary key autoincrement ," +
                COL_MODEL  +" TEXt  ," +
                  COL_COLOr +" Text  )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       // عمليات التعديل

    }
    // insert
    public boolean insertCar(Car c ){
          SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COLOr ,c.getColor());
        values.put(COL_MODEL,c.getModel());
        //  values.put(COL_id,c.getId());
        long res = db.insert(TABLE_NAME,null,values);
        return res != -1 ;


    }
    // update
    public boolean updatetCar(Car c ){
          SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COLOr ,c.getColor());
        values.put(COL_MODEL,c.getModel());

        long res = db.update(TABLE_NAME,values,null,null);
        return res > 0 ;


    }

    // method return num of row in taple
    public  long getCarsCount(){
       SQLiteDatabase db = getReadableDatabase();
       return DatabaseUtils.queryNumEntries(db,TABLE_NAME);

    }


}
