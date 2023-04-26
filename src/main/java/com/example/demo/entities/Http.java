package com.example.demo.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HTTP")
public class Http extends Ipadresse{
}
