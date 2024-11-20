package cashcontrol.mat.api.features.caixa.repository;

import cashcontrol.mat.api.features.caixa.model.entity.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}