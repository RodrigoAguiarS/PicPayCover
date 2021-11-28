package br.com.rodrigo.picpaycover.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rodrigo.picpaycover.R
import br.com.rodrigo.picpaycover.data.Transacao

class HomeAdapter(val transacoes: List<Transacao>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_transacao,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = transacoes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transacao = transacoes[position]
        holder.bind(transacao)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(transacao: Transacao) {
            with(itemView) {
                textViewOrigem.text = transacao.origem.nomeCompleto
                textViewDestino.text = transacao.destino.nomeCompleto
                textViewValor.text = transacao.valor.formatarMoeda()
                textViewData.text = transacao.dataHora.formatar()
                textViewCirculo.text = transacao.origem.nomeCompleto.first().toUpperCase().toString()
            }
        }
    }

}