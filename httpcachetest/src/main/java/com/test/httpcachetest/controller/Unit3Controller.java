package com.test.httpcachetest.controller;

import com.test.httpcachetest.controller.util.ApiResponse;
import com.test.httpcachetest.model.Unit3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.test.httpcachetest.dao.Unit3Dao;

@RestController
public class Unit3Controller {
    @Autowired
    Unit3Dao dao;

    @GetMapping( value = "/Units3")
    public List<Unit3>  allUnits(){
        List<Unit3> ors = dao.findAll();
        return ors;
    }

    @GetMapping( value = "/Units3/{id}")
    public Optional<Unit3> getUnit(@PathVariable int id) {
        Optional<Unit3> or = dao.findById(id);
        return or;
    }

    @PostMapping(value="/Units3")
    public ApiResponse<Unit3> createUnit(@RequestBody Unit3 u){
        return new ApiResponse<Unit3>(HttpStatus.OK.value(), "Created", dao.save(u));
    }

    @PutMapping(value = "/Units3/{id}")
    public ApiResponse<Unit3> updateUnit(@PathVariable int id, @RequestBody Unit3 u){
        Optional<Unit3> unit = dao.findById(id);
        if(Objects.isNull(unit)){
            return new ApiResponse<Unit3>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        u.setUnit3ID(id);
        return new ApiResponse<Unit3>(HttpStatus.OK.value(), "Unit " +id+" Updated", dao.save(u));
    }

    @DeleteMapping(value = "/Units3/{id}")
    public ApiResponse<Void> deleteUnit(@PathVariable int id){
        if(Objects.isNull(dao.findById(id))){
            return new ApiResponse<Void>(HttpStatus.NOT_FOUND.value(), "Unit "+id+" Not Found", null);
        }
        dao.deleteById(id);
        return new ApiResponse<Void>(HttpStatus.OK.value(), "Unit "+id+" deleted", null);
    }
}
