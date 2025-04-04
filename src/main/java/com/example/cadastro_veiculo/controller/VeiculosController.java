package com.example.cadastro_veiculo.controller;

import com.example.cadastro_veiculo.controller.dto.CarDTO;
import com.example.cadastro_veiculo.domain.Car;
import com.example.cadastro_veiculo.service.CarService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.cadastro_veiculo.controller.dto.CarDTO.toCar;
import static com.example.cadastro_veiculo.controller.dto.CarDTO.updateCarFields;
import static com.example.cadastro_veiculo.util.DateUtil.stringToLocalDateTime;

@RestController
@RequestMapping("carros")
public class VeiculosController {

    private final CarService serviceCar;

    public VeiculosController(CarService serviceCar) {
        this.serviceCar = serviceCar;
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getByFilter(
            @RequestParam(name = "veiculo", required = false) String veiculo,
            @RequestParam(name = "marca", required = false) String marca,
            @RequestParam(name = "ano", required = false) Integer ano,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "vendido", required = false) Boolean vendido,
            @RequestParam(name = "criadoEm", required = false) String criadoEm,
            @RequestParam(name = "atualizadoEm", required = false) String atualizadoEm
    ) {
        List<Car> cars = serviceCar.getByFilter(
                CarDTO.builder()
                        .veiculo(veiculo)
                        .marca(marca)
                        .ano(ano)
                        .descricao(descricao)
                        .vendido(vendido)
                        .criadoEm(stringToLocalDateTime(criadoEm))
                        .atualizadoEm(stringToLocalDateTime(atualizadoEm))
                        .build());

        return ResponseEntity.ok(
                CarDTO.toCarDto(cars));
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody CarDTO carDto) {
        Car carSaved = serviceCar.save(toCar(carDto));

        return new ResponseEntity<>(carSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@RequestBody CarDTO carDto, @PathVariable Long id) throws BadRequestException {
        Car carSaved = serviceCar.update(toCar(carDto), id);

        return ResponseEntity.ok(carSaved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updatePartial(@RequestBody CarDTO carDto, @PathVariable Long id) throws BadRequestException {
        Car carSaved = serviceCar.updatePartial(updateCarFields(carDto), id);

        return ResponseEntity.ok(carSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceCar.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
