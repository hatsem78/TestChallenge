package com.wenance.Challenge.wenance.Challenge.repository;


import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface WenanceChallengeRepository extends JpaRepository<WenanceChallenge, Long> {

    WenanceChallenge findByLprice(Double lprice);

    WenanceChallenge findByCurr1AndAndDate(String currency, Date date);

    @Query(value="SELECT new com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum(" +
            " u.curr1, avg(u.lprice), max(u.lprice), round((((max(u.lprice)-avg(u.lprice))/avg(u.lprice)) * 100), 2) )" +
            " FROM WenanceChallenge u  where u.curr1 = :currency and u.date between :timeStart and :timeEned"
            )
    DifferencePercentageAveragngeValueMaximum findByCurr1AndDateBetween(@Param("currency") String currency, @Param("timeStart") Date timeStart, @Param("timeEned") Date timeEnd);

}
