package cashcontrol.mat.api.features.movimentacao.repository;

import cashcontrol.mat.api.features.movimentacao.model.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}