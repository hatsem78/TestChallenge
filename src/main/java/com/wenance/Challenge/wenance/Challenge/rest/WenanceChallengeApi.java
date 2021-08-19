package com.wenance.Challenge.wenance.Challenge.rest;

import com.wenance.Challenge.wenance.Challenge.Dao.WenanceChallengeDao;
import com.wenance.Challenge.wenance.Challenge.domain.DifferencePercentageAveragngeValueMaximum;
import com.wenance.Challenge.wenance.Challenge.domain.WenanceChallenge;
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

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Validated
@RequestMapping(value = "/currency")
@RestController
public class WenanceChallengeApi {
    private static final Logger logger = LoggerFactory.getLogger(WenanceChallengeApi.class);

    @Autowired
    private WenanceChallengeDao wenanceChallengeService;
    @Autowired
    private CalorieTrackingUtils calorieTrackingUtils;


    @GetMapping(value ="/GetPriceBitcoinEthereumTimestamp")
    public ResponseEntity<WenanceChallenge> GetPriceBitcoinEthereumTimestamp
            (@RequestParam(required = true)  String currency,
             @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date, HttpServletResponse respons)
            throws EntityNotFoundException {
        WenanceChallenge responseEntity = wenanceChallengeService.findByCurr1AndAndDate(currency, date);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }


    @GetMapping(value ="/GetDifferencePercentageAverageValueMaximum")
    public ResponseEntity<DifferencePercentageAveragngeValueMaximum> GetDifferencePercentageAverageValueMaximum
            (@RequestParam(required = true)  String currency,
             @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
             @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate, HttpServletResponse respons)
            throws EntityNotFoundException {
        DifferencePercentageAveragngeValueMaximum responseEntity = wenanceChallengeService.findByCurr1AndDateBetween(currency, startDate, endDate);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }
}
