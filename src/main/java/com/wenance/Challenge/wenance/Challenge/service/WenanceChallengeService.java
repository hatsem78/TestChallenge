package com.wenance.Challenge.wenance.Challenge.service;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDaoImpl;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;


@Component
public class WenanceChallengeService {


    private WenanceChallengeDaoImpl wenanceChallengeDaoImpl;

    public Boolean createWenanceChallenge(WenanceChallenge wenanceChallenge) {
        return wenanceChallengeDaoImpl.WenanceChallengeAdd(wenanceChallenge);
    }

    public WenanceChallenge findByLprice(@PathVariable Double lprice) {
        WenanceChallenge wenanceChallenge = this.wenanceChallengeDaoImpl.findByLprice(lprice);
        return wenanceChallenge;
    }

    public WenanceChallenge findByCurr1AndAndDate(String currency, Date date) {
        return wenanceChallengeDaoImpl.findByCurr1AndAndDate(currency, date) ;
    }

}
