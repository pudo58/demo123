package com.insmart.Training.Repository;

import com.insmart.Training.Entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("SELECT d.id,(SELECT p.name FROM Province p WHERE p.id = d.province.id) ,d.name FROM District d ORDER BY d.province.id")
    List<Object[]> findAllData();
    @Query("SELECT d.id,(SELECT p.name FROM Province p WHERE p.id = d.province.id) ,d.name FROM District d WHERE d.province.id IN (?1) ORDER BY d.province.id")
    public List<Object[]> getDistrictsByMultiProvinceId(List<Integer> id);
}

