package com.personal.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
abstract public class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    private Date createdOn;
    private Date updatedOn;
}
