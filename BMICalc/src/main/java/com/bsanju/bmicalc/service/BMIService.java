package com.bsanju.bmicalc.service;
import com.bsanju.bmicalc.model.BMI;
import com.bsanju.bmicalc.repository.BMIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BMIService {

    @Autowired
    private BMIRepository bmiRepository;

    public BMI calculateAndSaveBMI(BMI bmiData) {
        double heightInMeters = bmiData.getHeight() / 100.0;
        double bmiValue = bmiData.getWeight() / (heightInMeters * heightInMeters);

        String category = "";
        if (bmiValue < 18.5) category = "Underweight";
        else if (bmiValue < 24.9) category = "Normal weight";
        else if (bmiValue < 29.9) category = "Overweight";
        else category = "Obese";

        bmiData.setBmi(bmiValue);
        bmiData.setCategory(category);

        return bmiRepository.save(bmiData);
    }

    public List<BMI> getHistory() {
        return bmiRepository.findAll();
    }
}
