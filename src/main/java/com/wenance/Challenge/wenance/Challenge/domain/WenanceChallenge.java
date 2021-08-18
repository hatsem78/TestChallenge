package com.wenance.Challenge.wenance.Challenge.domain;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "WenanceChallenge")
public class WenanceChallenge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWenanceChallenge;

    @NotEmpty
    private String curr1;

    @NotEmpty
    private String curr2;

    @NotNull
    private Date date;

    @NotNull
    private Double lprice;

    public WenanceChallenge(String curr1, String curr2, Date date, Double lprice) {
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.date = date;
        this.lprice = lprice;
    }

    public WenanceChallenge() {
    }
}

