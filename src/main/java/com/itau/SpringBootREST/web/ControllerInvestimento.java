package com.itau.SpringBootREST.web;

import com.itau.SpringBootREST.persistence.Investimento;
import com.itau.SpringBootREST.service.ServiceInvestimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ControllerInvestimento {

    @Autowired
    private ServiceInvestimento serviceInvestimento;

    @GetMapping("/Investimentos")
    public List<Investimento> getAll(){
        return serviceInvestimento.getAll();
    }

    @GetMapping("/about")
    public String about(){
        return "Simulador de Investimentos " ;
    }

    @PostMapping("/Investimento")
    public Investimento simularInvestimento(@RequestBody Investimento dadosEntrada){
        dadosEntrada.setValorFinal(serviceInvestimento.simular(dadosEntrada));
        return serviceInvestimento.create(dadosEntrada);
    }

}
