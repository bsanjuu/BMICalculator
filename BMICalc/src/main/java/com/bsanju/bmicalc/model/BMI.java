package com.bsanju.bmicalc.model;


import jakarta.persistence.*;

@Entity
@Table(name = "bmi_records")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class BMI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private double height;
    private double weight;
    private double bmi;
    private String category;


}
