package com.example.demo.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TELNET")
public class Telnet extends Ipadresse{
}
