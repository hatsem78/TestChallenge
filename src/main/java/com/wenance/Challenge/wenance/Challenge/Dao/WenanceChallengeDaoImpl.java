package com.wenance.Challenge.wenance.Challenge.Dao;

import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.repository.WenanceChallengeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;


public class WenanceChallengeDaoImpl implements WenanceChallengeDao {

    private WenanceChallengeRepository wenanceChallengeRepository;

    @Override
    @Transactional(readOnly = true)
    public WenanceChallenge getPriceBicoinEtherem(String currency, Date date) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public DifferencePercentageAveragngeValueMaximum differencePercentageAveragngeValueMaximum(Date startDate, Date endDate) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WenanceChallenge> getAllWenanceChallenge() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WenanceChallenge> getAllWenanceChallengeFilterDate(Date date) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean WenanceChallengeAdd(WenanceChallenge wenanceChallenge) {
        wenanceChallengeRepository.save(wenanceChallenge);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public WenanceChallenge findByLprice(Double lprice) {
        return wenanceChallengeRepository.findByLprice(lprice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WenanceChallenge> ListWenanceChallenge() {
        return (List<WenanceChallenge>) wenanceChallengeRepository.findAll();
    }
}
