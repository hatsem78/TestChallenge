package com.wenance.Challenge.wenance.Challenge;

import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.repository.WenanceChallengeRepository;
import net.minidev.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final WenanceChallengeRepository WenanceChallengeRepository;

    public ScheduledTasks(WenanceChallengeRepository wenanceChallengeRepository) {
        this.WenanceChallengeRepository = wenanceChallengeRepository;
    }


    @Scheduled(cron = "0/10 * * * * *")
    @Transactional()
    public void scheduleTaskTenSecondsETH() throws IOException {
        logger.info("scheduleTaskTenSecondsETH Rate Task ETH/USD :: scheduleTaskTenSeconds", dateTimeFormatter.format(LocalDateTime.now()) );
        task("https://cex.io/api/last_price/ETH/USD");
    }

    @Scheduled(cron = "0/10 * * * * *")
    @Transactional()
    public void scheduleTaskTenSecondsBTC() throws IOException {
        logger.info("scheduleTaskTenSecondsBTC Rate Task BTC/USD :: scheduleTaskTenSeconds", dateTimeFormatter.format(LocalDateTime.now()) );
        task("https://cex.io/api/last_price/BTC/USD");
    }

    public void task(String url) throws IOException {
        logger.info("scheduleTaskTenSecondsETH Rate Task :: scheduleTaskTenSeconds", dateTimeFormatter.format(LocalDateTime.now()) );
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String bodyResponse = "";
        try {

            HttpResponse responses = null;
            try {
                responses = httpClient.execute(get);
            } catch (IOException e) {
                e.printStackTrace(System.out);

            }

            if (responses.getStatusLine().getStatusCode() != 200){
                logger.error("scheduleTaskTenSecondsETH - Not communication url renaper   error ", responses.getStatusLine().getReasonPhrase());
            }

            HttpEntity entityResponse = responses.getEntity();
            String json = EntityUtils.toString(entityResponse, StandardCharsets.UTF_8);

            JSONParser parser = new JSONParser(json);
            JSONObject obj = new JSONObject(parser.parseObject());

            WenanceChallenge wenanceChallenge = new WenanceChallenge();

            obj.forEach((key, value) -> {
                if ("curr2".equals(key)) {
                    wenanceChallenge.setCurr2(value.toString());
                } else if ("curr1".equals(key)) {
                    wenanceChallenge.setCurr1(value.toString());
                } else if ("lprice".equals(key)) {
                    wenanceChallenge.setLprice(Double.parseDouble(value.toString()));
                }
            });
            wenanceChallenge.setDate(new Date());

            saveWenanceChallenge(wenanceChallenge);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }

        logger.info("scheduleTaskTenSecondsETH Final Rate Task :: scheduleTaskTenSeconds", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    public void saveWenanceChallenge(WenanceChallenge wenanceChallenge) {
        WenanceChallengeRepository.save(wenanceChallenge);
    }
}
