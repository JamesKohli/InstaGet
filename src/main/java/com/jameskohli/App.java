package com.jameskohli;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    public void initialize(Bootstrap<InstaGetConfiguration> bootstrap){}

    @Override
    public void run(InstaGetConfiguration configuration, Environment environment) {
      final HelloWorldResource helloWorldResource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.jersey().register(helloWorldResource);
        environment.healthChecks().register("template", templateHealthCheck);

    }
}
