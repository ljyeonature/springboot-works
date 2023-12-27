package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="dept")
public class Department {

    @Id
    private Integer deptno;
    private String  dname;
    private String  loc;
}
