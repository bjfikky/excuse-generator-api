package com.benorim.excusegeneratorapi.model;

public class Excuse {
    private Intro intro;
    private Scapegoat scapegoat;
    private Delay delay;

    public Excuse(Intro intro, Scapegoat scapegoat, Delay delay) {
        this.intro = intro;
        this.scapegoat = scapegoat;
        this.delay = delay;
    }

    public Intro getIntro() {
        return intro;
    }

    public void setIntro(Intro intro) {
        this.intro = intro;
    }

    public Scapegoat getScapegoat() {
        return scapegoat;
    }

    public void setScapegoat(Scapegoat scapegoat) {
        this.scapegoat = scapegoat;
    }

    public Delay getDelay() {
        return delay;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Excuse{" +
                "intro=" + intro +
                ", scapegoat=" + scapegoat +
                ", delay=" + delay +
                '}';
    }
}
