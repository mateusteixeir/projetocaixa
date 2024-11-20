package cashcontrol.mat.api.features.caixa.model.entity;

import cashcontrol.mat.api.features.caixa.model.dto.DadosCadastroCaixaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "caixas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Caixa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(name = "saldo_inicial", nullable = false)
    private Double saldoInicial;

    public Caixa(DadosCadastroCaixaDTO dadosCadastroCaixa){
        this.descricao = dadosCadastroCaixa.descricao();
        this.saldoInicial = dadosCadastroCaixa.saldoInicial();
    }
}