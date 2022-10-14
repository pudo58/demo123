package com.insmart.Training.Service;

import com.insmart.Training.Entity.District;
import com.insmart.Training.Entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DistrictServiceImplement extends ProvinceService  {
    @Autowired
    DistrictService districtRepository;
    @Autowired
    ProvinceService provinceService;
    public List<District> getDistricts(Integer province_id) {
        int pivot = 0;
        List<District> districts = new LinkedList<>();
                for(District district : districtRepository.getDistricts()) {
                    if(district.getProvince().getId().equals(province_id)) {
                        districts.add(district);
                        pivot++;
                    }
                }
    if(pivot == 0) {
        throw new IllegalArgumentException("District not found");
    }
        return districts;
    }
    public List<Province> getByProvinceId() {
        List<Province> provinces = new LinkedList<>();
        Province province1;
        for(Province province : provinceService.getProvinces()) {
                province1 = new Province();
                province1.setId(province.getId());
                province1.setName(province.getName());
                provinces.add(province);
        }
        return provinces;
    }
}

