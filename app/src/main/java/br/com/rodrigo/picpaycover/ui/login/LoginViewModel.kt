package br.com.rodrigo.picpaycover.ui.login

import androidx.lifecycle.ViewModel
import br.com.rodrigo.picpaycover.data.UsuarioLogado

class LoginViewModel : ViewModel() {

    fun isUsuarioLogado() = UsuarioLogado.isUsuarioLogado()

    fun isUsuarioNaoLogado() = !isUsuarioLogado()

}