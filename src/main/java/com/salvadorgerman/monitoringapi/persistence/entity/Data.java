package com.salvadorgerman.monitoringapi.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private int temperature;
    private int humidity;
    private int co2;

    @Column(name = "cpuTemp")
    private int cpuTemp;
    private int device;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Data data = (Data) o;
        return id != null && Objects.equals(id, data.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
