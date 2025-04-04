package com.example.cadastro_veiculo.controller.dto;

import com.example.cadastro_veiculo.domain.Car;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CarDTO {

    private Long id;
    private String veiculo;
    private String marca;
    private Integer ano;
    private String descricao;
    private Boolean vendido;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public static List<CarDTO> toCarDto(List<Car> cars) {
        return cars.stream()
                .map(car -> CarDTO.builder()
                        .id(car.getId())
                        .veiculo(car.getVeiculo())
                        .marca(car.getMarca())
                        .ano(car.getAno())
                        .descricao(car.getDescricao())
                        .vendido(car.getVendido())
                        .criadoEm(car.getCriadoEm())
                        .atualizadoEm(car.getAtualizadoEm())
                        .build())
                .collect(Collectors.toList());
    }

    public static Car toCar(CarDTO carDto) {
        return Car.builder()
                .veiculo(carDto.getVeiculo())
                .marca(carDto.getMarca())
                .ano(carDto.getAno())
                .descricao(carDto.getDescricao())
                .vendido(carDto.getVendido())
                .build();
    }
    public static Car toCar(CarDTO carDto, Long id) {
        return Car.builder()
                .id(id)
                .veiculo(carDto.getVeiculo())
                .marca(carDto.getMarca())
                .ano(carDto.getAno())
                .descricao(carDto.getDescricao())
                .vendido(carDto.getVendido())
                .build();
    }

    public static Car updateCarFields(CarDTO carDto) {
        return Car.builder()
                .ano(carDto.getAno())
                .descricao(carDto.getDescricao())
                .vendido(carDto.getVendido())
                .build();
    }
}
