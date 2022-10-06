package com.reto.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column
    private Integer idMessage;
    @Column
    private String messageText;

    //RELATIONS
    //@ManyToOne//(JoinBy = "cabinId")
    //@JoinColumn (name = "cabinId")
    //@JsonIgnoreProperties(value = {"messages","reservations"})
    //private Cabin cabin;

    //@ManyToOne(JoinBy = "clientId")
    //@JsonIgnoreProperties(value = {"messages","reservations"})
    //private Client client;

}
