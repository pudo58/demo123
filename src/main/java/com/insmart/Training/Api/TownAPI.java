package com.insmart.Training.Api;

import com.insmart.Training.Entity.Town;
import com.insmart.Training.Service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/towns")
public class TownAPI {
    @Autowired
    TownService townService;
    @GetMapping("/all")
    public List<Town> getTowns() {
        return townService.getTowns();
    }
    @GetMapping("/{id}")
    public Town getTown(Integer id) {
        return townService.getTown(id);
    }
    @GetMapping("/add")
    public Town create(Town town) {
        return townService.create(town);
    }
    @GetMapping("/update/{id}")
    public Town update(Town town,Integer id) {
        return townService.update(town,id);
    }
    @GetMapping("/delete/{id}")
    public void delete(Integer id) {
        townService.delete(id);
    }
}
