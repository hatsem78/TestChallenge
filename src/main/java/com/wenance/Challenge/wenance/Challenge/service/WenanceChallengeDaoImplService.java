package com.wenance.Challenge.wenance.Challenge.service;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.repository.WenanceChallengeRepository;
import net.minidev.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class WenanceChallengeDaoImplService implements WenanceChallengeDao {

    private static final Logger logger = LoggerFactory.getLogger(WenanceChallengeDaoImplService.class);

    @Autowired
    private WenanceChallengeRepository wenanceChallengeRepository;

    @Override
    @Transactional(readOnly = true)
    public WenanceChallenge getPriceBicoinEtherem(String currency, Date date) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WenanceChallenge> getAllWenanceChallengeFilterDate(Date date) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean WenanceChallengeAdd(WenanceChallenge wenanceChallenge) {
        wenanceChallengeRepository.save(wenanceChallenge);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public WenanceChallenge findByLprice(Double lprice) {
        return wenanceChallengeRepository.findByLprice(lprice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WenanceChallenge> ListWenanceChallenge() {
        return (List<WenanceChallenge>) wenanceChallengeRepository.findAll();
    }

    @Override
    public WenanceChallenge findByCurr1AndAndDate(String currency, Date date) {
        return wenanceChallengeRepository.findByCurr1AndAndDate(currency, date) ;
    }

    @Override
    public DifferencePercentageAveragngeValueMaximum DifferencePercentageAveragngeValueMaximum(String currency, Date startDate, Date endDate) {
        return wenanceChallengeRepository.findByCurr1AndDateBetween(currency, startDate, endDate) ;
    }

    @Override
    public Page<WenanceChallenge> paginateCurrencyDate(String currency, Date date, Pageable pageable) {
        return wenanceChallengeRepository.findByCurr1ContainingAndDate(currency, date, pageable) ;
    }

    @Override
    public Page<WenanceChallenge> paginateCurr1(String currency, Pageable pageable) {
        return wenanceChallengeRepository.findByCurr1Containing(currency, pageable);
    }

    @Override
    public WenanceChallenge getCurrencyMaxDate(String currency) {
        return wenanceChallengeRepository.findByCurr1(currency);
    }

    public Map<String, String> convertCurrencyUsd(String currency, String amnt) throws IOException {
        WenanceChallenge wenanceChallenge = new WenanceChallenge();        
        return convert("https://cex.io/api/convert/BTC/USD", currency, amnt);
    }

    public Map<String, String> convert(String url, String currency, String amnt) throws IOException {
        WenanceChallenge result = this.getCurrencyMaxDate(currency);
        HttpPost httppost = new HttpPost(url);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("amnt", amnt));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        CloseableHttpClient httpClient = HttpClients.createDefault();

        /* lista de propiedades */
        Map<String, String> convertUsd = new LinkedHashMap<String, String>();
        String bodyResponse = "";
        try {

            HttpResponse responses = null;

            try {
                responses = httpClient.execute(httppost);
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

            
            convertUsd.put("carrency", currency);
            convertUsd.put("convertUsd", "USD");
            convertUsd.put("lastLpriceDb", result.getLprice().toString());
            convertUsd.put("price", "");

            obj.forEach((key, value) -> {
                convertUsd.put("price", value.toString());
            });
            System.out.println(convertUsd);


        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return convertUsd;
    }
}
