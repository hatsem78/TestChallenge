package com.wenance.Challenge.wenance.Challenge.domain;
import lombok.Data;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Data
@Accessors(chain=true)
public class DifferencePercentageAveragngeValueMaximum {
    private String currency;
    @Null
    private Double max;
    @Null
    private Double average;
    @Null
    private Double PercentageDifference;
    private Long id;

    public DifferencePercentageAveragngeValueMaximum() {
    }

    public DifferencePercentageAveragngeValueMaximum(String currency, Double max, Double average, Double percentageDifference) {
        this.currency = (currency !=null)? currency : " ";
        this.max = (max !=null)? max : 0.0;;
        this.average = (average !=null)? average : 0.0;;
        this.PercentageDifference = (PercentageDifference !=null)? PercentageDifference : 0.0;;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getPercentageDifference() {
        return PercentageDifference;
    }

    public void setPercentageDifference(double percentageDifference) {
        PercentageDifference = percentageDifference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
