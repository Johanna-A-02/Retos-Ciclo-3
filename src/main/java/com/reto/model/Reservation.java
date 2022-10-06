package com.reto.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
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
    //@ManyToOne (JoinBy = "cabinId")
    //@JsonIgnoreProperties(value = "reservations")
    //private Cabin cabin;

    //@ManyToOne (JoinBy = "clientId")
    //@JsonIgnoreProperties(value = {"reservations","messages"})
    //private Client client;

    //@OneToMany(mappedBy = "reservation", cascade = {CascadeType.REMOVE})
    //@JsonIgnoreProperties(value = "reservation")
    //private Score score;

}
