package com.hms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "date", nullable = false)
    private LocalDate date;



    private double perNightPrice;

    public double getPerNightPrice() {
        return perNightPrice;
    }

    public void setPerNightPrice(double perNightPrice) {
        this.perNightPrice = perNightPrice;
    }

    //Getters and setter for count
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count){
        this.count = count;
    }


}