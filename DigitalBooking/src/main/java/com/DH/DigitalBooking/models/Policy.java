package com.DH.DigitalBooking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="id", insertable=false,updatable=false)
    private String documentation;

    public Policy(String documentation) {
        this.documentation = documentation;
    }


}
