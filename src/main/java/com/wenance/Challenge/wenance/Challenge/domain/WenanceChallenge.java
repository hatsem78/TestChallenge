package com.wenance.Challenge.wenance.Challenge.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="wenance_challenge")
@Data
@Accessors(chain=true)
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

