package br.com.rodrigo.picpaycover

import android.app.Application
import br.com.rodrigo.picpaycover.di.daoModule
import br.com.rodrigo.picpaycover.di.repositoryModule
import br.com.rodrigo.picpaycover.di.serviceModule

import br.com.rodrigo.picpaycover.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(viewModelModule, serviceModule, repositoryModule, daoModule)
        }
    }
}