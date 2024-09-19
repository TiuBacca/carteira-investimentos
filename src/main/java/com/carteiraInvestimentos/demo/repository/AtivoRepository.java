package com.carteiraInvestimentos.demo.repository;

import com.carteiraInvestimentos.demo.domain.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoRepository extends  JpaRepository<Ativo, Long> {

}
