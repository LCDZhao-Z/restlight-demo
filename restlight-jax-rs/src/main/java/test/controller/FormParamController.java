package test.controller;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Path("/formParam")
public class FormParamController {

    @POST
    @Path("/singleMap")
    public String singleMap(@FormParam("") Map<String, String> singleMap) {
        System.out.println(singleMap);
        return singleMap.toString();
    }

    @POST
    @Path("/multiMap")
    public String multiMap(@FormParam("") Map<String, List<String>> multiMap) {
        System.out.println(multiMap);
        return multiMap.toString();
    }

    @POST
    @Path("/value")
    public String value(@FormParam("value") Integer value) {
        return value.toString();
    }

    @POST
    @Path("/valueDefault")
    public String valueDefault(@FormParam(value = "value") @DefaultValue("8888") Integer value) {
        return value.toString();
    }

    @POST
    @Path("/values")
    public String values(@FormParam("value") List<Integer> values) {
        return values.toString();
    }

    @POST
    @Path("/valuesWithDefault")
    public String valuesWithDefault(@FormParam(value = "value") @DefaultValue("8888") List<Integer> values) {
        return values.toString();
    }
}
