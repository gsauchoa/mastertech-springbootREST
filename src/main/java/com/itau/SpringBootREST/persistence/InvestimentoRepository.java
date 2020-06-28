package com.itau.SpringBootREST.persistence;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InvestimentoRepository extends CrudRepository <Investimento, Integer> {
List<Investimento> findAll();
}
