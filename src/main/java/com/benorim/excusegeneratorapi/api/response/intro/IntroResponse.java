package com.benorim.excusegeneratorapi.api.response.intro;

public class IntroResponse {
    private String intro;

    public IntroResponse(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
