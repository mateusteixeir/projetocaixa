package cashcontrol.mat.api.features.caixa.controller;

import cashcontrol.mat.api.features.caixa.model.dto.DadosAtualizacaoCaixaDTO;
import cashcontrol.mat.api.features.caixa.model.dto.DadosCadastroCaixaDTO;
import cashcontrol.mat.api.features.caixa.model.dto.DadosListagemCaixaDTO;
import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import cashcontrol.mat.api.features.caixa.repository.CaixaRepository;
import cashcontrol.mat.api.features.caixa.service.CaixaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("caixas")
public class CaixaController{

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private CaixaService caixaService;

    @PostMapping
    public ResponseEntity<Caixa> cadastrar(@RequestBody DadosCadastroCaixaDTO dadosCadastroCaixa){

        Caixa caixa = new Caixa(dadosCadastroCaixa);

        Caixa caixaCadastrado = caixaService.cadastrar(caixa);

        return ResponseEntity.ok(caixaCadastrado);
    }

    @PutMapping("/{idCaixa}")
    public ResponseEntity<Caixa> atualizar(@RequestBody DadosAtualizacaoCaixaDTO dadosAtualizacaoCaixaDTO, @PathVariable long idCaixa){

        Caixa caixa = caixaRepository.findById(idCaixa).orElseThrow(() -> new RuntimeException("Caixa não encontrado"));
        caixa.setDescricao(dadosAtualizacaoCaixaDTO.descricao());
        caixa.setSaldoInicial(dadosAtualizacaoCaixaDTO.saldoInicial());

        Caixa caixaAtualizado = caixaService.atualizar(caixa);

        return ResponseEntity.ok(caixaAtualizado);
    }
    /*
    @GetMapping
    public Page<DadosListagemCaixaDTO> listar(Pageable paginacao){
        return caixaRepository.findAll(paginacao).map(DadosListagemCaixaDTO::new);

    }
     */
    @GetMapping
    public List<DadosListagemCaixaDTO> listar() {
        return caixaRepository.findAll().stream().map(DadosListagemCaixaDTO::new).toList();
    }


    @DeleteMapping("/{idCaixa}")
    public ResponseEntity<Caixa> deletar(@PathVariable Long idCaixa){

        Caixa caixaDeletado = caixaService.deletarCaixa(idCaixa);
        return ResponseEntity.ok(caixaDeletado);
    }

}