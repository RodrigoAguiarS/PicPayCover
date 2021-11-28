package br.com.rodrigo.picpaycover.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodrigo.picpaycover.data.Login
import br.com.rodrigo.picpaycover.data.State
import br.com.rodrigo.picpaycover.data.Usuario
import br.com.rodrigo.picpaycover.data.UsuarioLogado
import br.com.rodrigo.picpaycover.services.ApiService
import kotlinx.coroutines.launch

class LoginViewModel(private val apiService: ApiService) : ViewModel() {

    val usuarioState = MutableLiveData<State<Usuario>>()

    fun login(login: Login) {
        usuarioState.value = State.Loading()
        viewModelScope.launch {
            try {
                val token = apiService.autenticar(login)
                UsuarioLogado.token = token
                val usuario = apiService.getUsuario(login.usuario)
                UsuarioLogado.usuario = usuario
                usuarioState.value = State.Success(usuario)
            } catch (e: Exception) {
                usuarioState.value = State.Error(e)
            }
        }
    }

}