package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.Size;
import com.websales.websales.responsitory.SizeResponitory;

@Service
public class SizeService {
    @Autowired
    private SizeResponitory responitory;

    public Size saveSize(Size size){
        return responitory.save(size);
    }

    public List<Size> saveSizes(List<Size> sizes){
        return responitory.saveAll(sizes);
    }

    public List<Size> getSizes(){
        return responitory.findAll();
    }

    public Size getSizeById(int id){
        return responitory.findById(id).orElse(null);
    }

    public String deleteSize(int id){
        responitory.deleteById(id);
        return "Size removed " + id;
    }

    public Size updateSize(Size size){
        Size existingSize = responitory.findById(size.getId()).orElse(null);
        existingSize.setSize(size.getSize());
        return responitory.save(existingSize);
    }
}
