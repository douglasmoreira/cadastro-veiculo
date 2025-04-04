package com.example.cadastro_veiculo.service;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import com.example.cadastro_veiculo.repository.CarRepository;
import com.example.cadastro_veiculo.service.filter.CarFilterManager;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private CarFilterManager carFilterManager;

    public List<Car> getByFilter(CarDTO filterDTO) {
        Specification<Car> spec = carFilterManager.buildSpecification(filterDTO);
        return carRepository.findAll(spec);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car car) throws BadRequestException {
        findByIdOrThrowBadRequestException(car.getId());
        return carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Car findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return carRepository.findById(id).orElseThrow(() -> new BadRequestException("Carro não encontrado"));
    }
}
