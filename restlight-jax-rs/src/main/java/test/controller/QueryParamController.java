package test.controller;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Path("/queryParam")
public class QueryParamController {

    @GET
    @Path("/singleMap")
    public String singleMap(@QueryParam("") Map<String, String> singleMap) {
        System.out.println(singleMap);
        return singleMap.toString();
    }

    @GET
    @Path("/multiMap")
    public String multiMap(@QueryParam("") Map<String, List<String>> multiMap) {
        System.out.println(multiMap);
        return multiMap.toString();
    }

    @GET
    @Path("/value")
    public String value(@QueryParam("value") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/valueDefault")
    public String valueDefault(@QueryParam(value = "value") @DefaultValue("8888") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/values")
    public String values(@QueryParam("value") List<Integer> values) {
        return values.toString();
    }

    @GET
    @Path("/valuesWithDefault")
    public String valuesWithDefault(@QueryParam(value = "value") @DefaultValue("8888") List<Integer> values) {
        return values.toString();
    }
}
