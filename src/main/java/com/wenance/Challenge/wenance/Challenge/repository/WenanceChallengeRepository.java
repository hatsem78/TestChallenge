package com.wenance.Challenge.wenance.Challenge.repository;


import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WenanceChallengeRepository extends JpaRepository<WenanceChallenge, Long> {
    WenanceChallenge findByLprice(Double lprice);

}
