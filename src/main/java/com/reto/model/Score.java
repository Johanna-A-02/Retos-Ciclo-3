package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @OneToOne
    @JoinColumn(name = "reservation", referencedColumnName = "idReservation")
    @JsonIgnoreProperties(value = "score")
    private Reservation reservation;

}
