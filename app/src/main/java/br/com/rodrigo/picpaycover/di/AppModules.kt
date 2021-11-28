package br.com.rodrigo.picpaycover.di


import br.com.rodrigo.picpaycover.ComponentesViewModel
import br.com.rodrigo.picpaycover.repository.TransacaoRepository
import br.com.rodrigo.picpaycover.repository.TransacaoRepositoryImpl
import br.com.rodrigo.picpaycover.services.ApiService
import br.com.rodrigo.picpaycover.services.RetrofitService
import br.com.rodrigo.picpaycover.ui.ajuste.AjusteViewModel
import br.com.rodrigo.picpaycover.ui.home.HomeViewModel
import br.com.rodrigo.picpaycover.ui.login.LoginViewModel
import br.com.rodrigo.picpaycover.ui.pagar.PagarViewModel
import br.com.rodrigo.picpaycover.ui.transacao.TransacaoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ComponentesViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { PagarViewModel(get()) }
    viewModel { AjusteViewModel() }
    viewModel { TransacaoViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}

val serviceModule = module {
    single { RetrofitService.create<ApiService>() }
}

val repositoryModule = module {
    single<TransacaoRepository> { TransacaoRepositoryImpl(get(), get()) }
}

val daoModule = module {
    single { AppDatabase.getInstance(androidContext()).transacaoDAO() }
}