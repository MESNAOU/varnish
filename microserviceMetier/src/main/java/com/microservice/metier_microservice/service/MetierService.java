package com.microservice.metier_microservice.service;

import com.microservice.metier_microservice.feignClient.utils.ApiResponse;
import com.microservice.metier_microservice.model.Unit1;
import com.microservice.metier_microservice.feignClient.ReferentielClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetierService {

    @Autowired
    private ReferentielClient referentielClient;

    public List<Unit1> getEntities() {
        return referentielClient.getAllUnits();
    }

    public Optional<Unit1> getEntity(int id) {
        return referentielClient.getUnitById(id);
    }

    public ApiResponse<Unit1> createEntity(Unit1 entity) {
        return referentielClient.createUnit(entity);
    }

    public ApiResponse<Unit1> updateEntity(int id, Unit1 entity) {
        return referentielClient.updateUnit(id, entity);
    }

    public void deleteEntity(int id) {
        referentielClient.deleteUnit(id);
    }
}
