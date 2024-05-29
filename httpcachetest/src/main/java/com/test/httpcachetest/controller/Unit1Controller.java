package com.test.httpcachetest.controller;

import com.test.httpcachetest.controller.util.ApiResponse;
import com.test.httpcachetest.model.Unit1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.test.httpcachetest.dao.Unit1Dao;

@RestController
public class Unit1Controller {
    @Autowired
    Unit1Dao dao;

    @GetMapping( value = "/Units1")
    public List<Unit1>  allUnits(){
        List<Unit1> ors = dao.findAll();
        return ors;
    }

    @GetMapping( value = "/Units1/{id}")
    public Optional<Unit1> getUnit(@PathVariable int id) {
        Optional<Unit1> or = dao.findById(id);
        return or;
    }

    @PostMapping(value="/Units1")
    public ApiResponse<Unit1> createUnit(@RequestBody Unit1 u){
        return new ApiResponse<Unit1>(HttpStatus.OK.value(), "Created", dao.save(u));
    }

    @PutMapping(value = "/Units1/{id}")
    public ApiResponse<Unit1> updateUnit(@PathVariable int id, @RequestBody Unit1 u){
        Optional<Unit1> unit = dao.findById(id);
        if(Objects.isNull(unit)){
            return new ApiResponse<Unit1>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        u.setUnit1ID(id);
        return new ApiResponse<Unit1>(HttpStatus.OK.value(), "Unit " +id+" Updated", dao.save(u));
    }

    @DeleteMapping(value = "/Units1/{id}")
    public ApiResponse<Void> deleteUnit(@PathVariable int id){
        if(Objects.isNull(dao.findById(id))){
            return new ApiResponse<Void>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        dao.deleteById(id);
        return new ApiResponse<Void>(HttpStatus.OK.value(), "Unit "+id+" deleted", null);
    }
}
