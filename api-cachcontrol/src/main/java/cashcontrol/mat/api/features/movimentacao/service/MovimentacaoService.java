package cashcontrol.mat.api.features.movimentacao.service;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import cashcontrol.mat.api.features.caixa.repository.CaixaRepository;
import cashcontrol.mat.api.features.movimentacao.model.entity.Movimentacao;
import cashcontrol.mat.api.features.movimentacao.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentacaoService{

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Transactional
    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao){

        return movimentacaoRepository.save(movimentacao);
    }

    @Transactional
    public Movimentacao atualizarMovimentacao(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao deletarMovimentacao(Long idMovimentacao){

        Movimentacao movimentacao = movimentacaoRepository.findById(idMovimentacao).orElseThrow(() -> new RuntimeException("Movimentacao não encontrada"));
        movimentacaoRepository.delete(movimentacao);
        return movimentacao;

    }



}