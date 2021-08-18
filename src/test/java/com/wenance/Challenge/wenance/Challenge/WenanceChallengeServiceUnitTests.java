package com.wenance.Challenge.wenance.Challenge;

import org.junit.Assert;
import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.service.WenanceChallengeService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.Date;


@SpringBootTest
public class WenanceChallengeServiceUnitTests {

    @InjectMocks
    private WenanceChallengeService wenanceChallengeService;

    @Mock
    private WenanceChallengeDao wenanceChallengeDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMovieServiceWhenQueriedWithAnIdThenGetExpectedMovie() {
        WenanceChallenge wenanceChallenge = new WenanceChallenge("BTC", "USD", new Date(), 44820.7);
        wenanceChallengeDao.WenanceChallengeAdd(wenanceChallenge);
        Mockito.when(wenanceChallengeDao.findByLprice(44820.7))
                .thenReturn(wenanceChallenge);

        WenanceChallenge result = wenanceChallengeService.retrieveWenanceChallengeByLprice(44820.7);

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }
}
