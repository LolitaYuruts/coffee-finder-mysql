package com.lolitaflamme.coffeefindermysql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coffee {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Beans beans;
    private String aroma;
    private Roast roast;
    private BigDecimal price;
    @JsonProperty("caffeine_content")
    private double caffeineContent;
}
