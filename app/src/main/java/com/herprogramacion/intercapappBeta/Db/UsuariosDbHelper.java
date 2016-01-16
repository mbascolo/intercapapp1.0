package com.herprogramacion.intercapappBeta.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matias on 07/01/2016.
 */
public class UsuariosDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Usuarios.db";
    public static final int DATABASE_VERSION = 1;


    public UsuariosDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Quotes
        db.execSQL(UsuariosDataSource.CREATE_USUARIOS_SCRIPT);
        //Insertar registros iniciales
        db.execSQL(UsuariosDataSource.INSERT_USUARIOS_SCRIPT);

    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        //Actualizar la base de datos
    }



}
