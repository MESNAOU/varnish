package com.microservice.metier_microservice.controller;

import com.microservice.metier_microservice.feignClient.utils.ApiResponse;
import com.microservice.metier_microservice.model.Unit1;
import com.microservice.metier_microservice.service.MetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metier")
public class MetierController {

    @Autowired
    private MetierService metierService;

    @GetMapping("/Unit1")
    public List<Unit1> getEntities() {
        return metierService.getEntities();
    }

    @GetMapping("/Unit1/{id}")
    public Optional<Unit1> getEntity(@PathVariable int id) {
        return metierService.getEntity(id);
    }

    @PostMapping("/Unit1")
    public ApiResponse<Unit1> createEntity(@RequestBody Unit1 entity) {
        return metierService.createEntity(entity);
    }

    @PutMapping("/Unit1/{id}")
    public ApiResponse<Unit1> updateEntity(@PathVariable int id, @RequestBody Unit1 entity) {
        return metierService.updateEntity(id, entity);
    }

    @DeleteMapping("/Unit1/{id}")
    public void deleteEntity(@PathVariable int id) {
        metierService.deleteEntity(id);
    }
}
