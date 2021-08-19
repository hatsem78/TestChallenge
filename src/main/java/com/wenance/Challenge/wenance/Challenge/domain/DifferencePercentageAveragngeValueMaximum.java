package com.wenance.Challenge.wenance.Challenge.domain;

public class DifferencePercentageAveragngeValueMaximum {
    String currency;
    double max;
    double average;
    double PercentageDifference;

    public DifferencePercentageAveragngeValueMaximum() {
    }

    public DifferencePercentageAveragngeValueMaximum(String currency, double max, double average, double percentageDifference) {
        this.currency = currency;
        this.max = max;
        this.average = average;
        this.PercentageDifference = percentageDifference;
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
}
