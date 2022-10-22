package com.benorim.excusegeneratorapi.api.response;

public class ExcuseResponse {
    private String excuse;

    public ExcuseResponse(String excuse) {
        this.excuse = excuse;
    }

    public String getExcuse() {
        return excuse;
    }

    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }
}
