package com.insmart.Training.Api;

import com.insmart.Training.Entity.Province;
import com.insmart.Training.Repository.ProvinceRepository;
import com.insmart.Training.Service.DistrictServiceImplement;
import com.insmart.Training.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceAPI {
    @Autowired
    ProvinceService provinceService;
    @Autowired
    DistrictServiceImplement districtServiceImplement;
    @GetMapping("/all")
    public List<Province> getProvinces() {
        return provinceService.getProvinces();
    }
    @GetMapping("/{id}")
    public Province getProvince(@PathVariable Integer id) {
        return provinceService.getProvince(id);
    }
    public Province create(Province province) {
        return provinceService.create(province);
    }
    public Province update(Province province,Integer id) {
        return provinceService.update(province,id);
    }
    public void delete(Integer id) {
        provinceService.delete(id);
    }
    @GetMapping("/a/")
    public List<Province> getProvincesByCountryId() {
        return districtServiceImplement.getByProvinceId();
    }
}
