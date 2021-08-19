package com.wenance.Challenge.wenance.Challenge.Dao;

import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public WenanceChallenge findByCurr1AndAndDate (String currency, Date date);

    public DifferencePercentageAveragngeValueMaximum findByCurr1AndDateBetween (String currency, Date startDate, Date endDate);

    public Page<WenanceChallenge> findByCurr1ContainingAndDate(String currency, Date date, Pageable pageable);

    public Page<WenanceChallenge>findByCurr1Containing(String currency, Pageable pageable);


}
