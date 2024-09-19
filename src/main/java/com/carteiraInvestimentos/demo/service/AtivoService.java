package com.carteiraInvestimentos.demo.service;

import com.carteiraInvestimentos.demo.domain.Ativo;
import com.carteiraInvestimentos.demo.enums.TipoAtivo;
import com.carteiraInvestimentos.demo.exceptions.OperacaoInvalidaException;
import com.carteiraInvestimentos.demo.exceptions.RegistroIncompletoException;
import com.carteiraInvestimentos.demo.filtro.AtivoFiltro;
import com.carteiraInvestimentos.demo.repository.AtivoRepository;
import com.carteiraInvestimentos.demo.request.AtivoRequest;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtivoService implements CRUDService {

   // private final EntityManager em;
    private final AtivoRepository ativoRepository;

    @Override
    public void salvar(Object object)  throws Exception  {
        try {
            AtivoRequest ativoRequest =  (AtivoRequest) object;
            validaSalvarAtivo(ativoRequest);

            Ativo domain = ativoRequest.getId() != null ? ativoRepository.findById(ativoRequest.getId()).get() : new Ativo();
            if (StringUtils.isBlank(ativoRequest.getTicker())){
                domain.setTicker(ativoRequest.getTicker());
            }

            if (StringUtils.isBlank(ativoRequest.getTipo())){
                 domain.setTipo(TipoAtivo.valueOf(ativoRequest.getTicker()));
            }

            //TODO VALIDAR SE O BOOLEAN PRIMITIVO NO CASO DE NULL PREENCHE SOZINHO COM FALSE 

            ativoRepository.save(domain);

        } catch (ClassCastException e){
            e.printStackTrace();
            //TODO COLOCAR LOG DE ERRO, VER QUAL A BIBLIOTECA AO CERTO
        }
    }

    @Override
    public void remover(Object object) {
        try {
            AtivoRequest ativoRequest =  (AtivoRequest) object;
            Ativo ativo = ativoRepository.findById(ativoRequest.getId()).orElseThrow( () -> new RegistroIncompletoException("Ativo com id informado não encontrado."));

            ativoRepository.save(ativo);

        } catch (ClassCastException e){
            e.printStackTrace();
            //TODO COLOCAR LOG DE ERRO, VER QUAL A BIBLIOTECA AO CERTO
        }
    }

    @Override
    public List listar(Object object) {
        try {
            AtivoFiltro filtro =  (AtivoFiltro) object;
            StringBuilder sb = new StringBuilder(" select new com.carteirainvestimenso.repository.AtivoResponse( at.id, at.ticker, at.tipo)" +
                    "  FROM Ativo at where at.id > 0  ");

            if (filtro.getId() != null){
                sb.append(" AND at.id = :filtroID");
            }

            if (StringUtils.isNotBlank(filtro.getTicker())){
                sb.append(" AND at.ticker ilike :filtroTicker");
            }

            if(filtro.getTipos() != null && !filtro.getTipos().isEmpty()){
                sb.append(" AND at.tipo in (:filtroTipos)");

            }

            String sql = sb.toString();
//            Query q = em.createQuery(sql);
//            if(sql.contains("filtroID")){
//                q.setParameter("filtroID", filtro.getId());
//            }
//            if(sql.contains("filtroTicker")){
//                q.setParameter("filtroTicker", filtro.getTicker());
//            }
//            if(sql.contains("filtroTipos")){
//                q.setParameter("filtroTipos", String.join(",", filtro.getTicker()));
//            }
//            return q.getResultList();
    return null;
        } catch (ClassCastException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private void validaSalvarAtivo(AtivoRequest request) throws Exception {
        if(request.getId() != null){
            Ativo ativo = ativoRepository.findById(request.getId()).orElseThrow( () -> new RegistroIncompletoException("Ativo com id informado não encontrado."));

            if(StringUtils.isBlank(request.getTicker())){
                throw new RegistroIncompletoException("Ticker não informado.");
            }

            if (StringUtils.isBlank(request.getTipo())){
                throw new RegistroIncompletoException("Tipo não informado.");
            } else {
                try {
                    TipoAtivo.valueOf(request.getTicker());
                } catch (IllegalArgumentException e) {
                    throw new RegistroIncompletoException("Tipo informado não existe.");
                }
            }
        }
    }
}
