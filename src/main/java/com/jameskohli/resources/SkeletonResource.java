package com.jameskohli.resources;

import com.jameskohli.views.SkeletonView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by James on 4/9/2015.
 */
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class SkeletonResource {

  @GET
  public SkeletonView getSkeleton() {
    return new SkeletonView();
  }
}
