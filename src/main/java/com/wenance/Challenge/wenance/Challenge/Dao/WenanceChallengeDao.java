package com.wenance.Challenge.wenance.Challenge.Dao;

import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;


import java.util.Date;
import java.util.List;

public interface WenanceChallengeDao {
    /* obtener el precio del Bitcoin o the Etherem en cierto timestamp */
    WenanceChallenge getPriceBicoinEtherem(String currency, Date date);

    public DifferencePercentageAveragngeValueMaximum differencePercentageAveragngeValueMaximum(Date startDate, Date endDate);

    public List<WenanceChallenge> getAllWenanceChallenge();

    public List<WenanceChallenge> getAllWenanceChallengeFilterDate(Date date);

    public Boolean WenanceChallengeAdd(WenanceChallenge wenanceChallenge);

    public WenanceChallenge findByLprice(Double lprice);

    public List<WenanceChallenge> ListWenanceChallenge();

}
