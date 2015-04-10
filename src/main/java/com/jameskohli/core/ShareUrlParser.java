package com.jameskohli.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by James on 4/10/2015.
 */
public class ShareUrlParser {

    private boolean isValidUrl;
    private boolean isPrivate;
    private String imageUrl;

    private static final Logger logger = LoggerFactory.getLogger(ShareUrlParser.class);

    public ShareUrlParser(String shareUrl) {

        isValidUrl = false;
        isPrivate = false;
        imageUrl = null;
        String regex = "^(http:\\/\\/|https:\\/\\/)instagram.com\\/p\\/"; //Only match strings beginning with https://instagram.com/p/
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(shareUrl);

        if (m.find()) {
            try {
                Document doc = Jsoup.connect(shareUrl).get();
                String title = doc.title();
                if (!title.equals("Page Not Found • Instagram")) {
                    isValidUrl = true;
                    Elements elements = doc.getElementsByAttributeValue("property", "og:image");
                    Element image = elements.first();
                    imageUrl = image.attr("content");
                }
            } catch (Exception e) {
                logger.warn("Not a valid instagram url", e);
            }
        }
    }

    public boolean getIsValidUrl() {
        return isValidUrl;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
