package test.controller;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.springframework.stereotype.Component;

@Component
@Path("/pathVariable")
public class PathVariableController {

    @GET
    @Path("/{id}")
    public String path(@PathParam("id")@DefaultValue("cvcvxc") String id) {
        System.out.println(id);
        return id.toString();
    }

}
