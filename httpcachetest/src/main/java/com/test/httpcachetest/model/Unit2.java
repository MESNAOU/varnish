package com.test.httpcachetest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Unit2 {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int unit2ID;

    private int att1;
    private String att2;
    private int att3;
    private String att4;
    private int att5;
}

