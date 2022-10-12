package com.benorim.excusegeneratorapi.service;

import com.benorim.excusegeneratorapi.Util.NumbersUtil;
import com.benorim.excusegeneratorapi.model.Scapegoat;
import com.benorim.excusegeneratorapi.repository.ScapegoatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScapegoatService {

    private final ScapegoatRepository scapegoatRepository;

    public ScapegoatService(ScapegoatRepository scapegoatRepository) {
        this.scapegoatRepository = scapegoatRepository;
    }

    public Scapegoat getRandomScapegoat() {
        List<Scapegoat> allScapegoats = getAllScapegoats();
        return allScapegoats.get(NumbersUtil.getRandomNumber(allScapegoats.size()));
    }

    public List<Scapegoat> getAllScapegoats() {
        return scapegoatRepository.findAll();
    }
}
