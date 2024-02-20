package com.ebru.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass // for super class
@SuperBuilder // to create an object from a class
@Data // setter getter methods
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    Long createAt;
    Long updateAt;
    boolean state;
}
