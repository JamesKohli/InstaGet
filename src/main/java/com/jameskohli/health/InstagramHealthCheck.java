package com.jameskohli.health;

import com.codahale.metrics.health.HealthCheck;
import com.jameskohli.core.ShareUrlParser;

/**
 * Created by James on 4/8/2015.
 */
public class InstagramHealthCheck extends HealthCheck {

  @Override
  protected Result check() throws Exception {
    final ShareUrlParser sup = new ShareUrlParser("https://instagram.com/p/sykBgGSGAF/");
    if (!sup.getIsValidUrl()) {
      return Result.unhealthy("Instagram not responding to valid url");
    }
    return Result.healthy();
  }
}
