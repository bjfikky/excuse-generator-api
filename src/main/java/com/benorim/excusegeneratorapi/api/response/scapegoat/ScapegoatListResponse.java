package com.benorim.excusegeneratorapi.api.response.scapegoat;

import java.util.List;

public class ScapegoatListResponse {
    private List<ScapegoatResponse> scapegoats;

    public ScapegoatListResponse(List<ScapegoatResponse> scapegoats) {
        this.scapegoats = scapegoats;
    }

    public List<ScapegoatResponse> getScapegoats() {
        return scapegoats;
    }

    public void setScapegoats(List<ScapegoatResponse> scapegoats) {
        this.scapegoats = scapegoats;
    }
}
