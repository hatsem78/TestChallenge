package com.wenance.Challenge.wenance.Challenge.repository;


import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WenanceChallengeRepository extends JpaRepository<WenanceChallenge, Long> {

    WenanceChallenge findByLprice(Double lprice);

    WenanceChallenge findByCurr1AndAndDate(String currency, Date date);

}
