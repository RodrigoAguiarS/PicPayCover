package br.com.rodrigo.picpaycover.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel
import br.com.rodrigo.picpaycover.R
import br.com.rodrigo.picpaycover.data.Transacao
import br.com.rodrigo.picpaycover.extension.formatarMoeda
import br.com.rodrigo.picpaycover.ui.login.LoginViewModel

import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val loginViewModel: LoginViewModel by viewModel()
    private val controlador by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        @@ -22,15 +29,31 @@ class HomeFragment : Fragment() {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (loginViewModel.isUsuarioNaoLogado()) {
            val direcao = HomeFragmentDirections.actionGlobalNavigationLogin()
            controlador.navigate(direcao)
            return;
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navView = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
        navView?.visibility = View.VISIBLE
        observarSaldo()
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val mockLista = listOf(Transacao("1", valor = 10.0), Transacao("2", valor = 20.0))
        recyclerView.adapter = HomeAdapter(mockLista)
    }

    private fun observarSaldo() {
        homeViewModel.saldo.observe(viewLifecycleOwner, Observer {
            textViewSaldo.text = it.formatarMoeda()
        })
    }
}