package com.patriciamape.appbdtesoros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Patri on 03/02/2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    //Tabla tesoros
    public static final String TABLE_TESOROS = "tesoros";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_ESTRELLAS = "estrellas";
    // Tabla pistas
    public static final String TABLE_PISTAS = "pistas";
    public static final String COLUMN_IDP = "_idPista";
    public static final String COLUMN_NOMBREP = "nombre";
    public static final String COLUMN_TIPO = "tipo";
    public static final String COLUMN_PREGUNTA = "pregunta";
    public static final String COLUMN_SOLUCION = "solucion";
    public static final String COLUMN_RESPUESTA = "respuesta";
    // Tabla herramientas
    public static final String TABLE_HERRAMIENTAS = "herramientas";
    public static final String COLUMN_IDH = "_idHerramienta";
    public static final String COLUMN_NOMBREH = "nombre";
    // Tabla usuarios
    public static final String TABLE_USUARIOS = "usuarios";
    public static final String COLUMN_IDU = "_idUsuarios";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_TACEPTADOS = "tAceptados";
    public static final String COLUMN_TCOMPLETADOS = "tCompletados";
    // Tabla tesoros_usuarios
    public static final String TABLE_USUARIOS_TESOROS = "usuarios_tesoros";
    // Tabla pistas_herramientas
    public static final String TABLE_PISTAS_HERRAMIENTAS = "pistas_herramientas";

    private static final String DATABASE_NAME = "tesoros.db";
    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_CREATE = "create table "
            + TABLE_TESOROS + "( " + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NOMBRE + " text not null, "
            + COLUMN_ESTRELLAS + " integer not null);"

            + "create table "
            + TABLE_PISTAS + "( " + COLUMN_IDP
            + " integer primary key autoincrement, "
            + COLUMN_NOMBREP + " text not null, "
            + COLUMN_PREGUNTA + " text not null, "
            + COLUMN_SOLUCION + " text not null, "
            + COLUMN_RESPUESTA + " text);"

            + "create table "
            + TABLE_HERRAMIENTAS + "( " + COLUMN_IDH
            + " integer primary key autoincrement, "
            + COLUMN_NOMBREH + " text not null);"

            + "create table "
            + TABLE_USUARIOS + "( " + COLUMN_IDU
            + " integer primary key autoincrement, "
            + COLUMN_PASS + " text not null);"

            + "create table "
            + TABLE_USUARIOS_TESOROS + "( " + COLUMN_IDU
            + " integer foreign key, "
            + COLUMN_ID + " integer foreign key);"

            + "create table "
            + TABLE_PISTAS_HERRAMIENTAS + "( " + COLUMN_IDP
            + " integer foreign key, "
            + COLUMN_IDH + " integer foreign key);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TESOROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PISTAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HERRAMIENTAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS_TESOROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PISTAS_HERRAMIENTAS);
        onCreate(db);
    }

}

