package com.bsanju.bmicalc.controller;


import com.bsanju.bmicalc.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bmi")
@CrossOrigin(origins = "*") // Allow frontend requests
public class BMIController {

    @Autowired
    private BMIService bmiService;

    @PostMapping("/calculate")
    public com.bsanju.bmicalc.model.BMI calculateBMI(@RequestBody com.bsanju.bmicalc.model.BMI bmiData) {
        return bmiService.calculateAndSaveBMI(bmiData);
    }

    @GetMapping("/history")
    public List<com.bsanju.bmicalc.model.BMI> getHistory() {
        return bmiService.getHistory();
    }
}
