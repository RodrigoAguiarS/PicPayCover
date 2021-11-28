package br.com.rodrigo.picpaycover.repository

import br.com.rodrigo.picpaycover.data.Transacao
import br.com.rodrigo.picpaycover.data.TransacaoDAO
import br.com.rodrigo.picpaycover.data.Usuario

interface TransacaoRepository {

    suspend fun getSaldo(login: String): Usuario

    suspend fun getTransacoes(login: String): List<Transacao>
}

class TransacaoRepositoryImpl(
    private val apiService: ApiService,
    private val transacaoDAO: TransacaoDAO
) : TransacaoRepository {

    override suspend fun getSaldo(login: String): Usuario = apiService.getSaldo(login)

    override suspend fun getTransacoes(login: String): List<Transacao> {
        val transacoes = apiService.getTransacoes(login).content.toModel()
        transacaoDAO.save(transacoes.toLocal())
        return transacoes
    }

}