package com.jameskohli.resources;

import com.jameskohli.views.HomeView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by James on 4/9/2015.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeViewResource {

  @GET
  public HomeView getSkeleton() {
    return new HomeView();
  }
}
