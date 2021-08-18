package com.wenance.Challenge.wenance.Challenge.service;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



public class WenanceChallengeService {
    @Autowired
    private WenanceChallengeDao wenanceChallengeDao;

    public Boolean createWenanceChallenge(@RequestBody WenanceChallenge wenanceChallenge) {
        return wenanceChallengeDao.WenanceChallengeAdd(wenanceChallenge);
    }

    public WenanceChallenge retrieveWenanceChallengeByLprice(@PathVariable Double lprice) {
        WenanceChallenge wenanceChallenge = this.wenanceChallengeDao.findByLprice(lprice);
        return wenanceChallenge;
    }

}
