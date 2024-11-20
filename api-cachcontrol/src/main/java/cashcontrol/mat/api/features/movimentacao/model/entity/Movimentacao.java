package cashcontrol.mat.api.features.movimentacao.model.entity;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import cashcontrol.mat.api.features.caixa.repository.CaixaRepository;
import cashcontrol.mat.api.features.movimentacao.model.dto.DadosCadastroMovimentacaoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Entity(name = "movimentacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimentacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_caixa")
    private Caixa caixa;

    private String descricao;

    private Double valor;

    public Movimentacao(DadosCadastroMovimentacaoDTO dadosMovimentacaoCaixa, CaixaRepository caixaRepository) {
        this.data = dadosMovimentacaoCaixa.data();
        this.tipo = dadosMovimentacaoCaixa.tipo();
        Caixa caixa = caixaRepository.findById(dadosMovimentacaoCaixa.idCaixa())
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrado"));
        this.caixa = caixa;
        this.descricao = dadosMovimentacaoCaixa.descricao();
        this.valor = dadosMovimentacaoCaixa.valor();
    }
}