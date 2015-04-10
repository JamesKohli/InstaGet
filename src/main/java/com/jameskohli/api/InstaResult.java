package com.jameskohli.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by James on 4/9/2015.
 */
public class InstaResult {

    private String url;
    private boolean isValid;

    public InstaResult() {}

    public InstaResult(String url, boolean isValid) {
        this.url = url;
        this.isValid = isValid;
    }

    @JsonProperty
    public String getUrl(){
        return url;
    }

    @JsonProperty
    public boolean getIsValid() {
        return isValid;
    }
}
