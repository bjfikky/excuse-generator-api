package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.model.Excuse;
import org.springframework.stereotype.Service;

@Service
public class ExcuseService {
    private final IntroService introService;
    private final ScapegoatService scapegoatService;
    private final DelayService delayService;

    public ExcuseService(IntroService introService, ScapegoatService scapegoatService, DelayService delayService) {
        this.introService = introService;
        this.scapegoatService = scapegoatService;
        this.delayService = delayService;
    }

    public String composeExcuse() {
        Excuse excuse = new Excuse(introService.getRandomIntro(), scapegoatService.getRandomScapegoat(), delayService.getRandomDelay());
        return excuse.getIntro().getText() + " " + excuse.getScapegoat().getText() + " " + excuse.getDelay().getText();
    }
}
