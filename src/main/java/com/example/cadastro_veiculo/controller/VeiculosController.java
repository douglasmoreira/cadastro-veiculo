package com.example.cadastro_veiculo.controller;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Cadastro de veiculos")
public interface VeiculosController {

    @Operation(summary = "Obter veiculo por filtro de veiculo, marca, ano, descrição, vendido, data criação, data atualização")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "busca Veiculo", content =
                    {@Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class))})})
    ResponseEntity<List<CarDTO>> getByFilter(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, String criadoEm, String atualizadoEm);

    @Operation(summary = "Salvar novo carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Salvar Veiculo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class))})})
    ResponseEntity<Car> save(CarDTO carDto);

    @Operation(summary = "Atualizar carro pelo id")
    ResponseEntity<Car> update(CarDTO carDto, Long id) throws BadRequestException;

    @Operation(summary = "Atualizar parcialmente carro pelo id")
    ResponseEntity<Car> updatePartial(CarDTO carDto, Long id) throws BadRequestException;

    @Operation(summary = "Deletar carro pelo id")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
