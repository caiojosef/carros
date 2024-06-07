package br.edu.uniara.lpi2.rest.controller;

import br.edu.uniara.lpi2.rest.model.Car;
import br.edu.uniara.lpi2.rest.model.CarPagingRepository;
import br.edu.uniara.lpi2.rest.model.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarController {

    @Autowired
    CarRepository repository;

    @Autowired
    CarPagingRepository pagingRepository;

    @GetMapping("/{id}")
    public Car one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro pesquisando id: " + id));
    }

    @GetMapping
    public ResponseEntity<?> all(@RequestParam int page, @RequestParam int size) {
        if (page < 0) {
            return ResponseEntity.badRequest().body("page deve ser >= 0");
        }
        if (size < 1 || size > 500) {
            return ResponseEntity.badRequest().body("size deve ser entre 1 e 500");
        }
        Pageable pageable = PageRequest.of(page, size);
        final Page<Car> listCar = pagingRepository.findAll(pageable);
        return ResponseEntity.ok(listCar.toList());
    }

    @PostMapping
    public ResponseEntity<Car> insert(@RequestBody Car car) {
        Car carSalvo = repository.save(car);
        return ResponseEntity.ok(carSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean carFound = repository.existsById(id);
        if (!carFound) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok(id + " foi removido");
    }
}
