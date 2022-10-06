package com.reto.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {

    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    @Column
    private String messageText;
    @Column
    private Integer stars;

    //RELATIONS
    //@OneToMany
    //@JsonIgnoreProperties(value = "score")
    //private Reservation reservation;

}
