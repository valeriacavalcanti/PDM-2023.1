package com.example.clicount

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BancoHelper(context: Context): SQLiteOpenHelper(context, "dados.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "create table instituicao(id integer autoincrement not null primary key, "
        sql += "nome text, contador integer)"
//        Log.i("APPBANCO", sql)
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table instituicao")
        this.onCreate(db)
    }
}