package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column
    private Date startDate;
    @Column
    private Date devolutionDate;
    @Column
    private String status;

    //RELATIONS
    @ManyToOne
    @JoinColumn(name = "cabinId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "reservations")
    private Cabin cabin;

    @ManyToOne
    @JoinColumn (name = "clientId", referencedColumnName = "idClient")
    @JsonIgnoreProperties(value = {"reservations","messages"})
    private Client client;

    @OneToOne
    @JoinColumn(name = "score", referencedColumnName = "idScore")
    @JsonIgnoreProperties(value = "reservation")
    private Score score;

}
