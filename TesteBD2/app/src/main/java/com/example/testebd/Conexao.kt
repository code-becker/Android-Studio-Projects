package com.example.testebd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//class conexão vai ficar com um erro, então vc clica com o botão direito
// e implementa o members do SQLiteOpenHelper
class Conexao(context: Context):
//o primeiro é parametro context,
// no segundo parametro vc coloca as "" e ele já poe o "name:" Automaticamente l
// no terceiro parametro vc coloca a versao do banco de dados

SQLiteOpenHelper(context, "banco", null,1){
    // aqui eu criei o nome do banco de dados e também os dado que serão inseridos
    val sql = arrayOf(
        "CREATE TABLE teste (id INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(30)," +
                " password varchar(30))",
        "INSERT INTO teste (username, password) VALUES (NULL, 'user', 'pass')",
        "INSERT INTO teste (username, password) VALUES (NULL, 'admin', '123')"
    )
    //logo abaixo no override lembre de apagar o ? que fica na frente de sqlitedatabase
    // pois a gente está especificando um tipo de banco de dados
    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach {
           // db?.execSQL(it), esse comando é o que vai executar o comando sql, ou seja
            // ele vai criar a tabela dentro do banco e executar o comando
            db.execSQL(it)

        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop apaga a tabela
        //db.execSQL(), dentro do parentes eu coloco apenas as aspas, e peço pra apagar
        // e logo embaixo eu coloco o onCreate para que ele crie a tabela novamente.
        db.execSQL("DROP TABLE teste")
        onCreate(db)

    }
}