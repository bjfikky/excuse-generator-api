package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.Util.NumbersUtil;
import com.benorim.excusegeneratorapi.model.Intro;
import com.benorim.excusegeneratorapi.repository.IntroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntroService {

    private final IntroRepository introRepository;

    public IntroService(IntroRepository introRepository) {
        this.introRepository = introRepository;
    }

    public Intro getRandomIntro() {
        List<Intro> allIntros = getAllIntros();
        return allIntros.get(NumbersUtil.getRandomNumber(allIntros.size()));
    }

    public List<Intro> getAllIntros() {
        return introRepository.findAll();
    }
}
