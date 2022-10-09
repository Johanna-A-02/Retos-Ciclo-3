package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@JsonPropertyOrder({ "idReservation", "startDate", "devolutionDate", "status", "cabin", "client", "score"})
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column
    private Timestamp startDate;
    @Column
    private Timestamp devolutionDate;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score", referencedColumnName = "idScore")
    @JsonIgnoreProperties(value = "reservation")
    private Score score;

}
