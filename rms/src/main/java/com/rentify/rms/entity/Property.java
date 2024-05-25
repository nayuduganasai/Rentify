package com.rentify.rms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String floorArea;
    @ManyToOne
    private PropertyType type;
}
