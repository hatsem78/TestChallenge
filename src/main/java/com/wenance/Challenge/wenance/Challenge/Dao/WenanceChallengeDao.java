package com.wenance.Challenge.wenance.Challenge.Dao;

import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.response.WenanceChallengeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WenanceChallengeDao {

    /* obtener el precio del Bitcoin o the Etherem en cierto timestamp */
    WenanceChallenge getPriceBicoinEtherem(String currency, Date date);

    public Boolean WenanceChallengeAdd(WenanceChallenge wenanceChallenge);

    public WenanceChallenge findByLprice(Double lprice);

    public List<WenanceChallenge> ListWenanceChallenge();

    public WenanceChallenge findByCurr1AndAndDate (String currency, Date date);

    public DifferencePercentageAveragngeValueMaximum DifferencePercentageAveragngeValueMaximum (String currency, Date startDate, Date endDate);

    public Page<WenanceChallenge> paginateCurrencyDate(String currency, Date date, Pageable pageable);

    public Page<WenanceChallenge>paginateCurr1(String currency, Pageable pageable);

    public Map<String, String> convertCurrencyUsd(String currency, String amnt) throws IOException;

    public WenanceChallenge getCurrencyMaxDate(String currency);


}
