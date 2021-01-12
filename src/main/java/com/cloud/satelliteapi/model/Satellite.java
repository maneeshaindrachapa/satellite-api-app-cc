package com.cloud.satelliteapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name="satellite")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Satellite {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("name")
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty("status")
    @Column(name = "status", nullable = false)
    private String status;

    @JsonProperty("health")
    @Column(name = "health", nullable = false)
    private boolean health;
}
