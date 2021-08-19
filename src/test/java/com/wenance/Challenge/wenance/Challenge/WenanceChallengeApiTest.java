package com.wenance.Challenge.wenance.Challenge;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.service.WenanceChallengeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import java.util.Date;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WenanceChallengeApiTest {

    @InjectMocks
    private WenanceChallengeService wenanceChallengeService;

    @Mock
    private WenanceChallengeDao wenanceChallengeDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @LocalServerPort
    private int port;

    @Before
    public void setup() {

        RestAssured.port = port;
    }

    @Test
    public void GetPriceBitcoinEthereumTimestamp() {
        /*findByCurr1AndAndDate*/
        Response response = RestAssured.when().get("/GetPriceBitcoinEthereumTimestamp/ETH/2021-08-18 19:07:11");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }

    @Test
    public void testGetFoods() {
        /*findByCurr1AndAndDate*/
        Response response = RestAssured.when().get("/GetDifferencePercentageAverageValueMaximum/ETH/2021-08-18 19:07:11/2021-08-18 19:08:00");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }
}
