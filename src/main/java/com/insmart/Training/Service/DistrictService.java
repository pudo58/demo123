package com.insmart.Training.Service;

import com.insmart.Training.Entity.District;
import com.insmart.Training.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;
    public List<District> getDistricts() {
        return districtRepository.findAll();
    }
    public District getDistrict(Integer id) {
        return districtRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("District not found"+id));
    }
    public District create(District district) {
        return districtRepository.save(district);
    }
    public District update(District district,Integer id) {
        District district1 = districtRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("District not found"+id));
        district1.setName(district.getName());
        return districtRepository.save(district1);
    }
    public void delete(Integer id) {
        districtRepository.deleteById(id);
    }
    public List<Object[]> getDistrictsByMultiProvinceId(List<Integer> province_id) {
        return districtRepository.getDistrictsByMultiProvinceId(province_id);
    }
    public List<Object[]> getAll(){
        return districtRepository.findAllData();
    }

}
