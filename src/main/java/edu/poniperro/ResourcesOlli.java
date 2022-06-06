package edu.poniperro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class ResourcesOlli  {

    @GET
    @Path("/wellcome")
    public String wellcome() {
        return "Wellcome Olivanders!";
    }



}