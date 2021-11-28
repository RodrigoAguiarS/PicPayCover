package br.com.rodrigo.picpaycover.data

object UsuarioLogado {

    var usuario: Usuario? = null

    fun isUsuarioLogado() = usuario !== null

}