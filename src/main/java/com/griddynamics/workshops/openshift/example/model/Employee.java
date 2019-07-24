package com.griddynamics.workshops.openshift.example.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
    @SequenceGenerator(sequenceName = "EMP_SEQ", allocationSize = 1, name = "EMP_SEQ")
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column(name = "FULL_NAME")
    String full_name;

    @Column(name = "ID_NUMBER")
    String id_number;
}
