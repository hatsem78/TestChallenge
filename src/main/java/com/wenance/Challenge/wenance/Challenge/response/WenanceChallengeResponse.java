package com.wenance.Challenge.wenance.Challenge.response;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class WenanceChallengeResponse extends ResponseRequest {

    @NotEmpty
    private String curr1;

    @NotEmpty
    private String curr2;

    @NotNull
    private Date date;

    @NotNull
    private Double lprice;


    public WenanceChallengeResponse(String curr1, String curr2, Date date, Double lprice) {
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.date = date;
        this.lprice = lprice;
    }

    public WenanceChallengeResponse() {
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLprice() {
        return lprice;
    }

    public void setLprice(Double lprice) {
        this.lprice = lprice;
    }
}

