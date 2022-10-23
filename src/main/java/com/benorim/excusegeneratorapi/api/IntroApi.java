package com.benorim.excusegeneratorapi.api;

import com.benorim.excusegeneratorapi.api.response.intro.IntroListResponse;
import com.benorim.excusegeneratorapi.api.response.intro.IntroResponse;
import com.benorim.excusegeneratorapi.model.Intro;
import com.benorim.excusegeneratorapi.service.IntroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/intros")
public class IntroApi {

    private final IntroService introService;

    public IntroApi(IntroService introService) {
        this.introService = introService;
    }

    @GetMapping("random-intro")
    public ResponseEntity<IntroResponse> getRandomIntro() {
        Intro randomIntro = introService.getRandomIntro();
        if (randomIntro != null) {
            return ResponseEntity.ok(new IntroResponse(randomIntro.getText()));
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<IntroListResponse> getAllScapegoats() {
        List<IntroResponse> introResponses = new ArrayList<>();
        introService.getAllIntros()
                .forEach(intro -> introResponses.add(new IntroResponse(intro.getText())));
        return ResponseEntity.ok(new IntroListResponse(introResponses));
    }
}
