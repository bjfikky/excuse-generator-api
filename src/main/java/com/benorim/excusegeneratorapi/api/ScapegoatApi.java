package com.benorim.excusegeneratorapi.api;

import com.benorim.excusegeneratorapi.api.response.ScapegoatListResponse;
import com.benorim.excusegeneratorapi.api.response.ScapegoatResponse;
import com.benorim.excusegeneratorapi.model.Scapegoat;
import com.benorim.excusegeneratorapi.service.ScapegoatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/scapegoats")
public class ScapegoatApi {

    private final ScapegoatService scapegoatService;

    public ScapegoatApi(ScapegoatService scapegoatService) {
        this.scapegoatService = scapegoatService;
    }

    @GetMapping("random-scapegoat")
    public ResponseEntity<ScapegoatResponse> getRandomScapegoat() {
        Scapegoat randomScapegoat = scapegoatService.getRandomScapegoat();
        if (randomScapegoat != null) {
            return ResponseEntity.ok(new ScapegoatResponse(randomScapegoat.getText()));
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<ScapegoatListResponse> getAllScapegoats() {
        List<ScapegoatResponse> scapegoatResponses = new ArrayList<>();
        scapegoatService.getAllScapegoats()
                .forEach(scapegoat -> scapegoatResponses.add(new ScapegoatResponse(scapegoat.getText())));
        return ResponseEntity.ok(new ScapegoatListResponse(scapegoatResponses));
    }
}
