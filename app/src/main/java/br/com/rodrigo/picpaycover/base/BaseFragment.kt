package br.com.rodrigo.picpaycover.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.rodrigo.picpaycover.data.UsuarioLogado

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verificarSeEstaLogado()
    }

    private fun verificarSeEstaLogado() {
        if (UsuarioLogado.isUsuarioLogado()) {
            vaiParaLogin()
        }
    }

    private fun vaiParaLogin() {

    }
}