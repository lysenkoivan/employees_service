package com.griddynamics.workshops.openshift.example.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JwtConfig {
    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.secret:secret}")
    private String secret;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

}
