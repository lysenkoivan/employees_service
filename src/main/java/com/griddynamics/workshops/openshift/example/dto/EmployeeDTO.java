package com.griddynamics.workshops.openshift.example.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeDTO {

    String full_name;
    String id_number;
}
