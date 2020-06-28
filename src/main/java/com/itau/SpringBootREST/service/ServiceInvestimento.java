package com.itau.SpringBootREST.service;

import com.itau.SpringBootREST.persistence.Investimento;
import com.itau.SpringBootREST.persistence.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceInvestimento {
    @Autowired
    private InvestimentoRepository investimentoRepository;

    public List<Investimento> getAll(){
        return investimentoRepository.findAll();
    }
    public Investimento create(Investimento investimento){
        return investimentoRepository.save(investimento);
    }



    public double simular(Investimento dadosentrada) {
        //prazo em meses
        //taxa em percentual ao ano
        double fator = 0;
        fator = 1 + (dadosentrada.getTaxa()/100);
        fator = Math.pow(fator, (dadosentrada.getPrazo())/12 );
        return dadosentrada.getValorInicial()*fator ;
    }
}
