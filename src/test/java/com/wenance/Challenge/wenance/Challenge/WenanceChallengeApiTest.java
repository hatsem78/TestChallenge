package com.wenance.Challenge.wenance.Challenge;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WenanceChallengeApiTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @LocalServerPort
    private int port;

    @Before
    public void setup() {

        RestAssured.port = port;
    }

    @Test
    public void GetPriceBitcoinEthereumTimestamp() {
        Response response = RestAssured.when().get("/currency/GetPriceBitcoinEthereumTimestamp?currency=ETH&date=2021-08-18 19:07:11");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }

    @Test
    public void GetDifferencePercentageAverageValueMaximum() {
        Response response = RestAssured.when().get("/currency/GetDifferencePercentageAverageValueMaximum?startDate=2021-08-18 19:07:11&endDate=2021-08-18 19:08:00&currency=BTC");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }


    @Test
    public void getAllBitcoinEthereumCurrencyAndDate() {
        Response response = RestAssured.when().get("/currency/getAllBitcoinEthereum?dateReport=2021-08-18 19:07:11&currency=BTC");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }

    @Test
    public void getAllBitcoinEthereum() {
        Response response = RestAssured.when().get("/currency/getAllBitcoinEthereum?currency=BTC");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }

    @Test
    public void convertBTCOrETHToUSD() {
        Response response = RestAssured.when().get("/currency/convertBTCOrETHToUSD?currency=BTC&amnt=2.2");

        assertEquals("200 must be returned", HttpStatus.OK.value(), response.statusCode());
    }
}
