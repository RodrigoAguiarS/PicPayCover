package br.com.rodrigo.picpaycover.di


import br.com.rodrigo.picpaycover.ui.home.HomeViewModel
import br.com.rodrigo.picpaycover.ui.login.LoginViewModel
import br.com.rodrigo.picpaycover.ui.pagar.PagarViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { LoginViewModel() }
    viewModel { PagarViewModel() }
}