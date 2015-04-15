package com.jameskohli.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by James on 4/14/2015.
 */
public class InstagetHealthCheck extends HealthCheck {

  @Override
  protected Result check() throws Exception {
    return Result.healthy();
  }
}
