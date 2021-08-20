package com.wenance.Challenge.wenance.Challenge;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.repository.WenanceChallengeRepository;
import com.wenance.Challenge.wenance.Challenge.service.WenanceChallengeDaoImplService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;


@SpringBootTest
public class WenanceChallengeServiceUnitTests {

    @Mock
    WenanceChallengeDaoImplService wenanceChallengeDaoServices = new WenanceChallengeDaoImplService();

    @Mock
    private WenanceChallengeDao wenanceChallengeDaoServicess;

    @MockBean
    WenanceChallengeRepository wenanceChallengeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        WenanceChallenge CURRENCY1 = new WenanceChallenge("BTC", "USD", new Date(), 44820.7);
        WenanceChallenge CURRENCY2 = new WenanceChallenge("BTC", "USD", new Date(), 200.0);
        WenanceChallenge CURRENCY3 = new WenanceChallenge("BTC", "USD", new Date(), 300.0);
        WenanceChallenge wenanceChallenge = new WenanceChallenge("BTC", "USD", new Date(), 44820.7);
        wenanceChallengeRepository.save(CURRENCY1);
        wenanceChallengeRepository.save(CURRENCY2);
        wenanceChallengeRepository.save(CURRENCY3);
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

        DifferencePercentageAveragngeValueMaximum test = new DifferencePercentageAveragngeValueMaximum(
                wenanceChallenge.getCurr1(),
                wenanceChallenge.getLprice(),
                wenanceChallenge.getLprice(),
                wenanceChallenge.getLprice()
        );

        Mockito.when(wenanceChallengeDaoServices.DifferencePercentageAveragngeValueMaximum(
                wenanceChallenge.getCurr1(),
                wenanceChallenge.getDate(),
                wenanceChallenge.getDate()
        ))
                .thenReturn(test);

        DifferencePercentageAveragngeValueMaximum result =
                wenanceChallengeDaoServices.DifferencePercentageAveragngeValueMaximum(
                        wenanceChallenge.getCurr1(),
                        wenanceChallenge.getDate(),
                        wenanceChallenge.getDate()
                );
        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurrency().toLowerCase());
    }

    @Test
    public void getCurrencyMaxDate() {
        WenanceChallenge wenanceChallenge = addCurrencyTest();

        Mockito.when(wenanceChallengeDaoServices.getCurrencyMaxDate(wenanceChallenge.getCurr1()))
                .thenReturn(wenanceChallenge);
        WenanceChallenge result = wenanceChallengeDaoServices.getCurrencyMaxDate(wenanceChallenge.getCurr1());



        Assert.assertEquals(wenanceChallenge.getCurr1().toLowerCase(), result.getCurr1().toLowerCase());
    }


    private WenanceChallenge addCurrencyTest() {
        WenanceChallenge wenanceChallenge = new WenanceChallenge("BTC", "USD", new Date(), 44820.7);
        wenanceChallengeRepository.save(wenanceChallenge);
        return wenanceChallenge;
    }


}
