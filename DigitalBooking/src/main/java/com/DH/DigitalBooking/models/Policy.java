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
    @Column(name="penalty_fee")
    private String penalty_fee;

    public Policy(String documentation) {
        this.documentation = documentation;
    }

    public Policy(String documentation, String penalty_fee){
        this.documentation = documentation;
        this.penalty_fee = penalty_fee;
    }


}