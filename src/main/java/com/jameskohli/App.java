package com.jameskohli;

import com.google.common.collect.ImmutableMap;
import com.jameskohli.health.TemplateHealthCheck;
import com.jameskohli.resources.SkeletonResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * Hello world!
 *
 */
public class App extends Application<InstaGetConfiguration>
{
    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "InstaGet";
    }

    @Override
    public void initialize(Bootstrap<InstaGetConfiguration> bootstrap){
      bootstrap.addBundle(new ViewBundle<InstaGetConfiguration>() {
        @Override
        public ImmutableMap<String, ImmutableMap<String, String>> getViewConfiguration(InstaGetConfiguration config) {
          return config.getViewRendererConfiguration();
        }
      });
      bootstrap.addBundle(new AssetsBundle());
      bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
      bootstrap.addBundle(new AssetsBundle("/assets/images", "/images", null, "images"));
    }

    @Override
    public void run(InstaGetConfiguration configuration, Environment environment) {
      final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(configuration.getTemplate());
      environment.jersey().register(new SkeletonResource());
    }
}
