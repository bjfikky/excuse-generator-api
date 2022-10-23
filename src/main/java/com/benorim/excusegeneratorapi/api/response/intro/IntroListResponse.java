package com.benorim.excusegeneratorapi.api.response.intro;

import java.util.List;

public class IntroListResponse {
    private List<IntroResponse> intros;

    public IntroListResponse(List<IntroResponse> intros) {
        this.intros = intros;
    }

    public List<IntroResponse> getIntros() {
        return intros;
    }

    public void setIntros(List<IntroResponse> intros) {
        this.intros = intros;
    }
}
