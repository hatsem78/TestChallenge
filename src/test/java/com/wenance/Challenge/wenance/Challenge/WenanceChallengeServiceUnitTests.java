package com.wenance.Challenge.wenance.Challenge;

import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.service.WenanceChallengeDaoImplService;
import org.junit.Assert;
import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class WenanceChallengeServiceUnitTests {

    @InjectMocks
    private WenanceChallengeDaoImplService wenanceChallengeDaoService;

    @Mock
    private WenanceChallengeDao wenanceChallengeDaoServices;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findByLprice() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();
        Mockito.when(wenanceChallengeDaoServices.findByLprice(44820.7))
                .thenReturn(wenanceChallenge);

        WenanceChallenge result = wenanceChallengeDaoServices.findByLprice(44820.7);

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }

    @Test
    public void getPriceBicoinEtherem() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();

        Mockito.when(wenanceChallengeDaoServices.getPriceBicoinEtherem(wenanceChallenge.getCurr1(), wenanceChallenge.getDate()))
                .thenReturn(wenanceChallenge);

        WenanceChallenge result = wenanceChallengeDaoServices.getPriceBicoinEtherem(wenanceChallenge.getCurr1(), wenanceChallenge.getDate());

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }

    @Test
    public void getAllWenanceChallengeFilterDate() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();

        Mockito.when(wenanceChallengeDaoServices.getAllWenanceChallengeFilterDate(wenanceChallenge.getDate()))
                .thenReturn((List<WenanceChallenge>) wenanceChallenge);

        List<WenanceChallenge> result = wenanceChallengeDaoServices.getAllWenanceChallengeFilterDate(wenanceChallenge.getDate());

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.get(0).getCurr1().toLowerCase());
    }

    @Test
    public void findByCurr1AndAndDate() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();

        Mockito.when(wenanceChallengeDaoServices.findByCurr1AndAndDate(wenanceChallenge.getCurr1(), wenanceChallenge.getDate()))
                .thenReturn(wenanceChallenge);

        WenanceChallenge result = wenanceChallengeDaoServices.findByCurr1AndAndDate(wenanceChallenge.getCurr1(), wenanceChallenge.getDate());

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }


    @Test
    public void DifferencePercentageAveragngeValueMaximum() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();



        DifferencePercentageAveragngeValueMaximum result =
                wenanceChallengeDaoServices.DifferencePercentageAveragngeValueMaximum(
                        wenanceChallenge.getCurr1(),
                        wenanceChallenge.getDate(),
                        wenanceChallenge.getDate()
                );
        Mockito.when(wenanceChallengeDaoServices.DifferencePercentageAveragngeValueMaximum(
                wenanceChallenge.getCurr1(),
                wenanceChallenge.getDate(),
                wenanceChallenge.getDate())
        )
                .thenReturn(result);

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurrency());
    }

    @Test
    public void getCurrencyMaxDate() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();


        WenanceChallenge result = wenanceChallengeDaoServices.getCurrencyMaxDate(wenanceChallenge.getCurr1());

        Mockito.when(wenanceChallengeDaoServices.getCurrencyMaxDate(wenanceChallenge.getCurr1()))
                .thenReturn(wenanceChallenge);

        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }


    private WenanceChallenge addCurrencyTest() {
        WenanceChallenge wenanceChallenge = new WenanceChallenge("BTC", "USD", new Date(), 44820.7);
        wenanceChallengeDaoServices.WenanceChallengeAdd(wenanceChallenge);
        return wenanceChallenge;
    }


}
