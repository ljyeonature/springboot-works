package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name="emp")
public class Employee {
    
    @Id
    private Integer empno;

    // @Column(name="lastname")
    private String  ename;

    @Column(nullable = true)
    private String  job;

    // @ColumnDefault(value="0") // 기존의 null 값이 있으면 오류가 남.
    @Column(nullable = true)
    private Integer mgr;

    @Column(nullable = true)
    private Date    hiredate;

    @Column(nullable = true)
    private Integer sal;

    @Column(nullable = true)
    private Integer comm;

    // @Column(nullable = true)
    // private Integer deptno;

    @ManyToOne(optional = true)
    @JoinColumn(name="deptno")
    private Department dept;

}
