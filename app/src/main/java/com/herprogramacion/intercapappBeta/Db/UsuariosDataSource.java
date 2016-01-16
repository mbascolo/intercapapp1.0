package com.herprogramacion.intercapappBeta.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Matias on 07/01/2016.
 */
public class UsuariosDataSource {

    //Metainformación de la base de datos
    public static final String USUARIOS_TABLE_NAME = "usuarios";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";


    //Campos de la tabla Quotes
    public static class ColumnaUsuarios{
        public static final String ID_USUARIOS = BaseColumns._ID;
        public static final String NOMBRE_USUARIO = "nombre";
        public static final String PASS_USUARIO = "password";
    }

    //Script de Creación de la tabla Clientes
    public static final String CREATE_USUARIOS_SCRIPT =
            "create table "+USUARIOS_TABLE_NAME+"(" +
                    ColumnaUsuarios.ID_USUARIOS+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnaUsuarios.NOMBRE_USUARIO+" "+STRING_TYPE+" not null," +
                    ColumnaUsuarios.PASS_USUARIO+" "+STRING_TYPE+" not null)";



    //Creación de la base de datos
    public static final String INSERT_USUARIOS_SCRIPT =
            "insert into "+USUARIOS_TABLE_NAME+" values(" +
                    "null," + "\"mbascolo\"," + "\"matias\")," +
                    "(null," + "\"ctrosch\"," + "\"claudio\")";


    private UsuariosDbHelper openHelper;
    private SQLiteDatabase database;

    public UsuariosDataSource(Context context){
        //Creando una instancia a la base de datos
        openHelper = new UsuariosDbHelper(context);
        database = openHelper.getWritableDatabase();

    }

}
