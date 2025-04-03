package com.bsanju.bmicalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMIRepository extends JpaRepository<com.bsanju.bmicalc.model.BMI, Long> {

}
