package com.jameskohli;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;

/**
 * Created by James on 4/8/2015.
 */
public class InstaGetConfiguration extends Configuration {

  @NotEmpty
  private String template;

  @NotEmpty
  private String defaultName = "User";

  @NotEmpty
  private String defaultImage;

  @NotNull
  private ImmutableMap<String, ImmutableMap<String, String>> viewRendererConfiguration = ImmutableMap.of();

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

    @JsonProperty
  public String getDefaultImage() {
      return defaultImage;
  }

  @JsonProperty
  public void setDefaultImage(String defaultImage) {
      this.defaultImage = defaultImage;
  }

  @JsonProperty("viewRendererConfiguration")
  public ImmutableMap<String, ImmutableMap<String, String>> getViewRendererConfiguration() {
    return viewRendererConfiguration;
  }

  @JsonProperty("viewRendererConfiguration")
  public void setViewRendererConfiguration(Map<String, Map<String, String>> viewRendererConfiguration) {
    ImmutableMap.Builder<String, ImmutableMap<String, String>> builder = ImmutableMap.builder();
    for (Map.Entry<String, Map<String, String>> entry : viewRendererConfiguration.entrySet()) {
      builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
    }
    this.viewRendererConfiguration = builder.build();
  }
}
