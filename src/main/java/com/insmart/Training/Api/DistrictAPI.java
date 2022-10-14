package com.insmart.Training.Api;

import com.insmart.Training.Entity.District;
import com.insmart.Training.Service.DistrictService;
import com.insmart.Training.Service.DistrictServiceImplement;
import com.insmart.Training.bean.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictAPI {
    @Autowired
    DistrictService districtService;
    @Autowired
    DistrictServiceImplement districtServiceImplement;
    @GetMapping("/all")
    public ResponseData<District> getDistricts() {
       if(!districtService.getDistricts().isEmpty()) {
           return new ResponseData<District>("", "Success", districtService.getDistricts(), HttpStatus.OK.value());
       }
        return new ResponseData<>("", "District not found", null, HttpStatus.NOT_FOUND.value());
    }
    @GetMapping("/{id}")
    public District getDistrict(@PathVariable  Integer id) {
        return districtService.getDistrict(id);
    }
    @PostMapping("/add")
    public District create(@RequestBody District district) throws Exception{
        if(district.getName().trim().equals("") ^ district.getProvince().getId() == null) {
            throw new Exception("District name or province id is null");
        }
        return districtService.create(district);
    }
    @PutMapping("/update/{id}")
    public District update(@RequestBody District district,@PathVariable Integer id) {
        return districtService.update(district,id);
    }
    @DeleteMapping(produces = "application/json",value = "/delete/{id}")
    public void delete(@PathVariable  Integer id) {
        districtService.delete(id);
    }
    @GetMapping("/province/{province_id}")
    public List<District> getDistrictsByProvinceId(@PathVariable Integer province_id) {
        return districtServiceImplement.getDistricts(province_id);
    }
    @GetMapping("/a/")
    public List<Object[]> getDistrictsByMunltiProvinceId(@RequestParam("province_id") List<Integer> province_id) {
        return districtService.getDistrictsByMultiProvinceId(province_id);
    }
    @GetMapping("/all-data/")
    public List<Object[]> getAllDistricts() {
        return districtService.getAll();
    }
}
