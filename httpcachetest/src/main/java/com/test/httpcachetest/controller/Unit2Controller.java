package com.test.httpcachetest.controller;

import com.test.httpcachetest.controller.util.ApiResponse;
import com.test.httpcachetest.model.Unit2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.test.httpcachetest.dao.Unit2Dao;

@RestController
public class Unit2Controller {
    @Autowired
    Unit2Dao dao;

    @GetMapping( value = "/Units2")
    public List<Unit2>  allUnits(){
        List<Unit2> ors = dao.findAll();
        return ors;
    }

    @GetMapping( value = "/Units2/{id}")
    public Optional<Unit2> getUnit(@PathVariable int id) {
        Optional<Unit2> or = dao.findById(id);
        return or;
    }

    @PostMapping(value="/Units2")
    public ApiResponse<Unit2> createUnit(@RequestBody Unit2 u){
        return new ApiResponse<Unit2>(HttpStatus.OK.value(), "Created", dao.save(u));
    }

    @PutMapping(value = "/Units2/{id}")
    public ApiResponse<Unit2> updateUnit(@PathVariable int id, @RequestBody Unit2 u){
        Optional<Unit2> unit = dao.findById(id);
        if(Objects.isNull(unit)){
            return new ApiResponse<Unit2>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        u.setUnit2ID(id);
        return new ApiResponse<Unit2>(HttpStatus.OK.value(), "Unit " +id+" Updated", dao.save(u));
    }

    @DeleteMapping(value = "/Units2/{id}")
    public ApiResponse<Void> deleteUnit(@PathVariable int id){
        if(Objects.isNull(dao.findById(id))){
            return new ApiResponse<Void>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        dao.deleteById(id);
        return new ApiResponse<Void>(HttpStatus.OK.value(), "Unit "+id+" deleted", null);
    }
}
