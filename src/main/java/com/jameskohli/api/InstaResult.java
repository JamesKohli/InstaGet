package com.jameskohli.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by James on 4/9/2015.
 */
public class InstaResult {

    private String url;

    public InstaResult() {}

    public InstaResult(String url) {
        this.url = url;
    }

    @JsonProperty
    public String getUrl(){
        return url;
    }
}
