package com.example.cadastro_veiculo.service.filter;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarFilterManager {
    private final List<CarFilter> filters;

    public CarFilterManager(List<CarFilter> filters) {
        this.filters = filters;
    }

    public Specification<Car> buildSpecification(CarDTO filterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (CarFilter filter : filters) {
                filter.applyFilter(root, query, criteriaBuilder, predicates, filterDTO);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
