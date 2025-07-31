package com.pooja.entity;

//import com.pooja.model.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "theatres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {

//    private String id;  // You mentioned id should be String

    @Id
//   @GeneratedValue(strategy = GenerationType.UUID) // ✅ for String UUID
    private String id;

    private String name;
    private String city;
    private String location;
    private int seating_capacity;
}