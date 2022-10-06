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
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Integer age;
    @Column
    private String password;

    //RELATIONS
    //@OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    //@JsonIgnoreProperties(value = "client")
    //private List<Message> messages;

    //@OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    //@JsonIgnoreProperties(value = "client")
    //private List<Reservation> reservations;
}
