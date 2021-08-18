package com.wenance.Challenge.wenance.Challenge;

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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(cron = "0/10 * * * * *")
    public void scheduleTaskTenSeconds() throws IOException {
        logger.info("Fixed Rate Task :: scheduleTaskTenSeconds", dateTimeFormatter.format(LocalDateTime.now()) );

        HttpGet get = new HttpGet("https://cex.io/api/last_price/ETH/USD");
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
                logger.error("TouchIdService - Not communication url renaper   error ", responses.getStatusLine().getReasonPhrase());
            }

            HttpEntity entityResponse = responses.getEntity();
            String json = EntityUtils.toString(entityResponse, StandardCharsets.UTF_8);

            JSONParser parser = new JSONParser(json);
            JSONObject obj = new JSONObject(parser.parseObject());

            obj.forEach((s, o) -> {
                System.out.println(s);
                System.out.println(o);

            });

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }




        System.out.println(bodyResponse);

        //{"lprice":"3107.2","curr1":"ETH","curr2":"USD"}
    }


}
