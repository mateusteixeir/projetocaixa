package cashcontrol.mat.api.features.caixa.model.dto;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;

public record DadosListagemCaixaDTO(Long id, String descricao) {
    public DadosListagemCaixaDTO (Caixa caixa){
        this(caixa.getId(), caixa.getDescricao());
    }
}