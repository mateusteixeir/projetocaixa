package cashcontrol.mat.api.features.movimentacao.controller;

import cashcontrol.mat.api.features.caixa.repository.CaixaRepository;
import cashcontrol.mat.api.features.movimentacao.model.dto.DadosAtualizacaoMovimentacaoDTO;
import cashcontrol.mat.api.features.movimentacao.model.dto.DadosCadastroMovimentacaoDTO;
import cashcontrol.mat.api.features.movimentacao.model.dto.DadosListagemMovimentacaoDTO;
import cashcontrol.mat.api.features.movimentacao.model.entity.Movimentacao;
import cashcontrol.mat.api.features.movimentacao.repository.MovimentacaoRepository;
import cashcontrol.mat.api.features.movimentacao.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacaoController{

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> cadastrar(@RequestBody DadosCadastroMovimentacaoDTO dadosCadastroMovimentacao){

        Movimentacao movimentacao = new Movimentacao(dadosCadastroMovimentacao, caixaRepository);

        Movimentacao movimentacaoCadastrada = movimentacaoService.cadastrarMovimentacao(movimentacao);

        return ResponseEntity.ok(movimentacaoCadastrada);
    }

    @PutMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> atualizar(@RequestBody DadosAtualizacaoMovimentacaoDTO dadosAtualizacaoMovimentacaoDTO, @PathVariable long idMovimentacao){

        Movimentacao movimentacao = movimentacaoRepository.findById(idMovimentacao).orElseThrow(() -> new RuntimeException("Movimentacao não encontrada"));
        movimentacao.setData(dadosAtualizacaoMovimentacaoDTO.data());
        movimentacao.setTipo(dadosAtualizacaoMovimentacaoDTO.tipo());
        movimentacao.setCaixa(dadosAtualizacaoMovimentacaoDTO.caixa());
        movimentacao.setDescricao(dadosAtualizacaoMovimentacaoDTO.descricao());
        movimentacao.setValor(dadosAtualizacaoMovimentacaoDTO.valor());

        Movimentacao movimentacaoAtualizada = movimentacaoService.atualizarMovimentacao(movimentacao);

        return ResponseEntity.ok(movimentacaoAtualizada);
    }
    /*
    @GetMapping
    public Page<DadosListagemCaixaDTO> listar(Pageable paginacao){
        return caixaRepository.findAll(paginacao).map(DadosListagemCaixaDTO::new);

    }
     */
    @GetMapping
    public List<DadosListagemMovimentacaoDTO> listar() {
        return movimentacaoRepository.findAll().stream().map(DadosListagemMovimentacaoDTO::new).toList();
    }


    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> deletar(@PathVariable Long idMovimentacao){

        Movimentacao movimentacaoDeletada = movimentacaoService.deletarMovimentacao(idMovimentacao);
        return ResponseEntity.ok(movimentacaoDeletada);
    }

}