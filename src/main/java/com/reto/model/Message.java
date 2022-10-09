package com.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "idMessage")
    private Integer idMessage;
    @Column
    private String messageText;

    //RELATIONS
    @ManyToOne
    @JoinColumn(name = "cabinId", referencedColumnName ="id")
    @JsonIgnoreProperties(value = {"messages","reservations"})
    private Cabin cabin;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "idClient")
    @JsonIgnoreProperties(value = {"messages","reservations"})
    private Client client;

}
