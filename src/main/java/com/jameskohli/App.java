package com.jameskohli;

import com.google.common.collect.ImmutableMap;
import com.jameskohli.health.InstagetHealthCheck;
import com.jameskohli.health.InstagramHealthCheck;
import com.jameskohli.resources.HomeViewResource;
import com.jameskohli.resources.UrlParserResource;
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
      environment.healthChecks().register("Instaget", new InstagetHealthCheck());
      environment.healthChecks().register("Instagram", new InstagramHealthCheck());
      environment.jersey().register(new HomeViewResource());
      environment.jersey().register(new UrlParserResource(configuration.getDefaultImage()));
    }
}
