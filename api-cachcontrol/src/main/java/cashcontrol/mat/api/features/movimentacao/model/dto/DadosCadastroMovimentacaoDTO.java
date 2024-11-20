package cashcontrol.mat.api.features.movimentacao.model.dto;


import java.util.Date;

public record DadosCadastroMovimentacaoDTO(Date data, String tipo, Long idCaixa, String descricao, Double valor) {
}