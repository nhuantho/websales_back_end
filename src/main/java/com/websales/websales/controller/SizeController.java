package com.websales.websales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.websales.model.Size;
import com.websales.websales.service.SizeService;

@RestController
@CrossOrigin("https://cute-lamington-afccc4.netlify.app/")
public class SizeController {
    @Autowired
    private SizeService service;

    @PostMapping("/addSize")
    public Size addSize(@RequestBody Size size){
        return service.saveSize(size);
    }

    @PostMapping("/addSizes")
    public List<Size> addSizes(@RequestBody List<Size> sizes){
        return service.saveSizes(sizes);
    }

    @GetMapping("/sizes")
    public List<Size> findAlLSizes(){
        return service.getSizes();
    }

    @GetMapping("/sizeById/{id}")
    public Size findSizeById(@PathVariable int id){
        return service.getSizeById(id);
    }

    @PutMapping("/updateSize")
    public Size update(@RequestBody Size size){
        return service.updateSize(size);
    }

    @DeleteMapping("/deleteSize/{id}")
    public String deleteSize(@PathVariable int id){
        return service.deleteSize(id);
    }
}
