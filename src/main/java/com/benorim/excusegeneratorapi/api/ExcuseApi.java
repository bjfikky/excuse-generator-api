package com.benorim.excusegeneratorapi.api;

import com.benorim.excusegeneratorapi.api.response.ExcuseResponse;
import com.benorim.excusegeneratorapi.service.ExcuseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/excuses")
public class ExcuseApi {

    private final ExcuseService excuseService;

    public ExcuseApi(ExcuseService excuseService) {
        this.excuseService = excuseService;
    }

    @GetMapping("random-excuse")
    public ResponseEntity<ExcuseResponse> getExcuse() {
        return ResponseEntity.ok(new ExcuseResponse(excuseService.composeExcuse()));
    }
}
