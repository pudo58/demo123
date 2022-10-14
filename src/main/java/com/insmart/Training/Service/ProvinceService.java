package com.insmart.Training.Service;

import com.insmart.Training.Entity.Province;
import com.insmart.Training.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    public List<Province> getProvinces() {
        return provinceRepository.findAll();
    }
    public Province getProvince(Integer id) {
        return provinceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Province not found"+id));
    }
    public Province create(Province province) {
        return provinceRepository.save(province);
    }
    public Province update(Province province,Integer id) {
        Province province1 = provinceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Province not found"+id));
        province1.setName(province.getName());
        return provinceRepository.save(province1);
    }
    public void delete(Integer id) {
        provinceRepository.deleteById(id);
    }
}
