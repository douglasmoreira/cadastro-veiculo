package com.example.cadastro_veiculo.service;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import com.example.cadastro_veiculo.repository.CarRepository;
import com.example.cadastro_veiculo.service.filter.CarFilterManager;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Car update(CarDTO updateDTO, Long id) throws BadRequestException {
        Car car = findByIdOrThrowBadRequestException(id);

        if (updateDTO.getVeiculo() != null) car.setVeiculo(updateDTO.getVeiculo());
        if (updateDTO.getMarca() != null) car.setMarca(updateDTO.getMarca());
        if (updateDTO.getAno() != null) car.setAno(updateDTO.getAno());
        if (updateDTO.getDescricao() != null) car.setDescricao(updateDTO.getDescricao());
        if (updateDTO.getVendido() != null) car.setVendido(updateDTO.getVendido());
        if (updateDTO.getCriadoEm() != null) car.setCriadoEm(updateDTO.getCriadoEm());
        if (updateDTO.getAtualizadoEm() != null) car.setAtualizadoEm(updateDTO.getAtualizadoEm());

        return carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Car findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return carRepository.findById(id).orElseThrow(() -> new BadRequestException("Carro não encontrado"));
    }
}
