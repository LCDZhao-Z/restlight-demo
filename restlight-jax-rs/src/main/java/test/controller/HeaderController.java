package test.controller;

import io.esastack.commons.net.http.HttpHeaders;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/header")
public class HeaderController {

    @GET
    @Path("/headers")
    public String header(@HeaderParam("headers") HttpHeaders headers) {
        headers.forEach((entry) -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
        return headers.toString();
    }

    @GET
    @Path("/headerValue")
    public String headerValue(@HeaderParam("value") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/headerValueWithDefault")
    public String headerValueWithDefault(@HeaderParam("value") @DefaultValue("8888") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/headerValues")
    public String headerValues(@HeaderParam("value") List<Integer> values) {
        return values.toString();
    }

    @GET
    @Path("/headerValuesWithDefault")
    public String headerValuesWithDefault(@HeaderParam("value") @DefaultValue("8888") List<Integer> values) {
        return values.toString();
    }

}
