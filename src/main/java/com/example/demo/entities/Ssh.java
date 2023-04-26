package com.example.demo.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SSH")
public class Ssh extends Ipadresse{
}
