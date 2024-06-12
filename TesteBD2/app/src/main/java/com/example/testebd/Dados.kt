package com.example.testebd


// aqui eu só coloco a quantidade de campo de acordo com a tabela do banco de dados
// clico com o botão direito em cima de DADOS e vou em generate > toString()
class Dados (val id: Int = 0 , val username: String = "", val password: String = "" ) {
    override fun toString(): String {
        return "Dados(id=$id, username='$username', password='$password')"
    }

}