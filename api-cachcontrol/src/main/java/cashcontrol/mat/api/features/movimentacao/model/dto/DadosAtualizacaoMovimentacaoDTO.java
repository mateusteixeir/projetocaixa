package cashcontrol.mat.api.features.movimentacao.model.dto;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;

import java.util.Date;

public record DadosAtualizacaoMovimentacaoDTO(Date data, String tipo, Caixa caixa, String descricao, Double valor) {
}