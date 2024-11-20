package cashcontrol.mat.api.features.caixa.service;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import cashcontrol.mat.api.features.caixa.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaixaService{

    @Autowired
    private CaixaRepository caixaRepository;

    @Transactional
    public Caixa cadastrar (Caixa caixa){

        return caixaRepository.save(caixa);
    }

    @Transactional
    public Caixa atualizar(Caixa caixa){
        return caixaRepository.save(caixa);
    }

    public Caixa deletarCaixa(Long idCaixa){

        Caixa caixa = caixaRepository.findById(idCaixa).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
        caixaRepository.delete(caixa);
        return caixa;

    }



}