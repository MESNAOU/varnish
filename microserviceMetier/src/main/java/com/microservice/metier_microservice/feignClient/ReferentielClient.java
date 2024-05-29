package com.microservice.metier_microservice.feignClient;

import com.microservice.metier_microservice.feignClient.utils.ApiResponse;
import com.microservice.metier_microservice.model.Unit1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "referentiel-service", url = "http://localhost:9001")
public interface ReferentielClient {

    @GetMapping("/Units1")
    List<Unit1> getAllUnits();

    @GetMapping("/Units1/{id}")
    Optional<Unit1> getUnitById(@PathVariable("id") int id);

    @PostMapping("/Units1")
    ApiResponse<Unit1> createUnit(@RequestBody Unit1 unit);

    @PutMapping("/Units1/{id}")
    ApiResponse<Unit1> updateUnit(@PathVariable("id") int id, @RequestBody Unit1 unit);

    @DeleteMapping("/Units1/{id}")
    ApiResponse<Void> deleteUnit(@PathVariable("id") int id);
}
