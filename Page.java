package com.beefyazilim.app.canlibilgiyarismasi;

import java.io.Serializable;

public enum Page implements Serializable {
    REGISTER(true),
    LOGIN(true),
    ABOUT(true),
    ASK(true),
    HINT(true),
    LEADER(true),
    PROFILE(true),
    WAIT(true),
    FALSE(true),
    TRUE(true),
    AVATAR(true),
    JOKER(true);


    private boolean effectTitle;

    Page(boolean _effectTitle) {
        effectTitle = _effectTitle;
    }

    public boolean hasEffectToTitle() {
        return effectTitle;
    }
}