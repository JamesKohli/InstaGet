package com.jameskohli;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by James on 4/8/2015.
 */
public class InstaGetConfiguration extends Configuration {

  @NotEmpty
  private String template;

  @NotEmpty
  private String defaultName = "User";

  @JsonProperty
  public String getTemplate() {
    return template;
  }

  @JsonProperty
  public void setTemplate(String template) {
    this.template = template;
  }

  @JsonProperty
  public String getDefaultName() {
    return defaultName;
  }

  @JsonProperty
  public void setDefaultName(String defaultName) {
    this.defaultName = defaultName;
  }
}
