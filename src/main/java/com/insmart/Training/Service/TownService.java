package com.insmart.Training.Service;

import com.insmart.Training.Entity.Town;
import com.insmart.Training.Repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TownService {
    @Autowired
    TownRepository townRepository;
    public List<Town> getTowns() {
        return townRepository.findAll();
    }
    public Town getTown(Integer id) {
        return townRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Town not found"+id));
    }
    public Town create(Town town) {
        return townRepository.save(town);
    }
    public Town update(Town town,Integer id) {

        Town town1 = townRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Town not found"+id));
        town1.setName(town.getName());
        town1.setDistrict(town.getDistrict());
        return townRepository.save(town1);
    }
    public void delete(Integer id) {
        townRepository.deleteById(id);
    }
}
