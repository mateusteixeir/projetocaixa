package cashcontrol.mat.api.features.movimentacao.model.dto;


import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import cashcontrol.mat.api.features.movimentacao.model.entity.Movimentacao;

import java.util.Date;

public record DadosListagemMovimentacaoDTO(Long id, Date data, String tipo, Caixa caixa, String descricao, Double valor) {
    public DadosListagemMovimentacaoDTO (Movimentacao movimentacao){
        this(
                movimentacao.getId(),
                movimentacao.getData(),
                movimentacao.getTipo(),
                movimentacao.getCaixa(),
                movimentacao.getDescricao(),
                movimentacao.getValor()
        );
    }
}