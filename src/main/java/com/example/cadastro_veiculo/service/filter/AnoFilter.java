package com.example.cadastro_veiculo.service.filter;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnoFilter implements CarFilter {
    @Override
    public void applyFilter(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
                            List<Predicate> predicates, CarDTO filterDTO) {
        if (filterDTO.getAno() != null) {
            predicates.add(criteriaBuilder.equal(root.get("ano"), filterDTO.getAno()));
        }
    }
}
