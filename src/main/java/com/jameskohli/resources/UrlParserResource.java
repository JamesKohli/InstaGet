package com.jameskohli.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.jameskohli.api.InstaResult;
import com.jameskohli.core.ShareUrlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by James on 4/9/2015.
 */
@Path("/gram")
@Produces(MediaType.APPLICATION_JSON)
public class UrlParserResource {

    private String defaultImage;

    private static final Logger logger = LoggerFactory.getLogger(UrlParserResource.class);

    public UrlParserResource(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    @GET
    @Timed
    public InstaResult parseShare(@QueryParam("shareUrl") Optional<String> shareUrl) {
        if (Optional.absent().equals(shareUrl)){
            return new InstaResult(defaultImage, false);
        } else {
            logger.info("Image requested at " + shareUrl);
            ShareUrlParser sup = new ShareUrlParser(shareUrl.get());
            logger.info("Returning result. isValid: " + sup.getIsValidUrl() + ", url: " + sup.getImageUrl());
            return new InstaResult(sup.getImageUrl(), sup.getIsValidUrl());
        }
    }
}
