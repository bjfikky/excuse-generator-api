package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.Util.NumbersUtil;
import com.benorim.excusegeneratorapi.model.Delay;
import com.benorim.excusegeneratorapi.repository.DelayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayService {

    private final DelayRepository delayRepository;

    public DelayService(DelayRepository delayRepository) {
        this.delayRepository = delayRepository;
    }

    public Delay getRandomDelay() {
        List<Delay> allDelays = getAllDelays();
        return allDelays.get(NumbersUtil.getRandomNumber(allDelays.size()));
    }

    public List<Delay> getAllDelays() {
        return delayRepository.findAll();
    }
}
