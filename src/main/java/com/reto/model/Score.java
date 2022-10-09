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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {

    @Id
    @Column(name = "idScore")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    @Column
    private String messageText;
    @Column
    private Integer stars;

    //RELATIONS
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "reservation", referencedColumnName = "idReservation")
    @JsonIgnoreProperties(value = "score")
    private Reservation reservation;

}
