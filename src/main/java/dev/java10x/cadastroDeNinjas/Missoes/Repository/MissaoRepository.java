package dev.java10x.cadastroDeNinjas.Missoes.Repository;

import dev.java10x.cadastroDeNinjas.Missoes.Model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {}
