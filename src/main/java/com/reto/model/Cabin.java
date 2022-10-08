package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cabin")
public class Cabin {

    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private Integer rooms;
    @Column
    private String description;

    //RELATIONS
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties(value = "cabins")
    private Category category;

    @OneToMany(mappedBy = "cabin", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties(value = {"cabin","client"})
    private List<Message> messages;

    @OneToMany(mappedBy = "cabin", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties(value = {"cabin","messages"})
    private List<Reservation> reservations;

}
