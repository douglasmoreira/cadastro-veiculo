package com.example.cadastro_veiculo.controller.dto;

import com.example.cadastro_veiculo.domain.Car;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CarDTO {

    @Schema(name = "id", description = "Product ID")
    private Long id;
    @Schema(name = "veiculo", description = "Veiculo", example = "Gol")
    private String veiculo;
    @Schema(name = "marca", description = "Marca", example = "Volkswagen")
    private String marca;
    @Schema(name = "ano", description = "Ano", example = "2007", required = true)
    private Integer ano;
    @Schema(name = "descricao", description = "Descrição", example = "Gol ano 2007 seminovo", required = true)
    private String descricao;
    @Schema(name = "vendido", description = "Foi Vendido?", example = "true", required = true)
    private Boolean vendido;
    @Schema(name = "criadoEm", description = "Data criação", example = "2025-04-04T09:49:28.459969975")
    private LocalDateTime criadoEm;
    @Schema(name = "atualizadoEm", description = "Data atualização", example = "2025-04-04T09:49:28.459969975")
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
