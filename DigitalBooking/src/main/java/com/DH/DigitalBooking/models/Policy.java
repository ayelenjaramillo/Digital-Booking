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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "policy_sequence")
    @SequenceGenerator(name="policy_sequence",sequenceName = "policy_sequence")
    @Column(name="id",insertable=false,updatable=false)
    private Long id;
    @Column
    private String documentation;

    public Policy(String documentation) {
        this.documentation = documentation;
    }



}
