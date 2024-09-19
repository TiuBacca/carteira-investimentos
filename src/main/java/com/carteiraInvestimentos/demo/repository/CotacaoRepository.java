package com.carteiraInvestimentos.demo.repository;

import com.carteiraInvestimentos.demo.domain.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
