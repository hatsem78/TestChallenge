package com.wenance.Challenge.wenance.Challenge.rest;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
import com.wenance.Challenge.wenance.Challenge.response.ResponseRequest;
import com.wenance.Challenge.wenance.Challenge.response.WenanceChallengeResponse;
import com.wenance.Challenge.wenance.Challenge.util.CalorieTrackingUtils;
import com.wenance.Challenge.wenance.Challenge.util.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Validated
@RequestMapping(value = "/currency")
@RestController
public class WenanceChallengeApi {
    private static final Logger logger = LoggerFactory.getLogger(WenanceChallengeApi.class);

    @Autowired
    private WenanceChallengeDao wenanceChallengeDaosService;

    @Autowired
    private CalorieTrackingUtils calorieTrackingUtils;


    @GetMapping(value ="/GetPriceBitcoinEthereumTimestamp")
    public ResponseEntity<WenanceChallenge> GetPriceBitcoinEthereumTimestamp (
            @RequestParam(required = true)  String currency,
            @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date
    ) throws EntityNotFoundException {

        WenanceChallenge responseEntity = wenanceChallengeDaosService.findByCurr1AndAndDate(currency, date);

        if(responseEntity == null) {
            ResponseRequest documentResponse = new ResponseRequest(
                    400,
                    "No se encontron informaciòn para los parametros: currency: " + currency + " date:" +  date
            );
            ResponseEntity responseEntitys = new ResponseEntity<ResponseRequest>(documentResponse, HttpStatus.BAD_REQUEST);

            return responseEntitys;
        }

        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }


    @GetMapping(value ="/GetDifferencePercentageAverageValueMaximum")
    public ResponseEntity<DifferencePercentageAveragngeValueMaximum> GetDifferencePercentageAverageValueMaximum (
            @RequestParam(required = true)  String currency,
            @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate
    ) throws EntityNotFoundException {
        DifferencePercentageAveragngeValueMaximum responseEntity = wenanceChallengeDaosService.DifferencePercentageAveragngeValueMaximum(currency, startDate, endDate);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @GetMapping(value ="/getAllBitcoinEthereum")
    public ResponseEntity<Map<String, Object>>  getAllBitcoinEthereum (
            @RequestParam(required = true)  String currency,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date dateReport,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) throws EntityNotFoundException {

        List<WenanceChallenge> WenanceChallengeList = new ArrayList<WenanceChallenge>();
        Pageable paging = PageRequest.of(page, size);

        Page<WenanceChallenge> pageWenanceChallenge;
        if (dateReport == null)
            pageWenanceChallenge = wenanceChallengeDaosService.paginateCurr1(currency, paging);
        else
            pageWenanceChallenge = wenanceChallengeDaosService.paginateCurrencyDate(currency, dateReport, paging);

        WenanceChallengeList = pageWenanceChallenge.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("tutorials", WenanceChallengeList);
        response.put("currentPage", pageWenanceChallenge.getNumber());
        response.put("totalItems", pageWenanceChallenge.getTotalElements());
        response.put("totalPages", pageWenanceChallenge.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/convertBTCOrETHToUSD")
    public ResponseEntity<Map<String, String>> convertBTCOrETHToUSD (
        @RequestParam(required = true)  String currency,
        @RequestParam(required = true)  String amnt
    ) throws EntityNotFoundException, IOException {
        Map<String, String> responseEntity = wenanceChallengeDaosService.convertCurrencyUsd(currency, amnt);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

}
