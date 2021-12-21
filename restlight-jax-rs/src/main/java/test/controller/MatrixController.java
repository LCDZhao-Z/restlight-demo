package test.controller;

import esa.commons.collection.MultiValueMap;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Path("/matrix")
public class MatrixController {

    @GET
    @Path("/singleMap/{id}")
    public String singleMap(@MatrixParam("") Map<String, String> singleMap) {
        System.out.println(singleMap);
        return singleMap.toString();
    }

    @GET
    @Path("/multiMap/{id}")
    public String multiMap(@MatrixParam("") MultiValueMap<String, String> multiMap) {
        System.out.println(multiMap);
        return multiMap.toString();
    }

    @GET
    @Path("/matrixValue/{id}")
    public String matrixValue(@MatrixParam("value") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/matrixValueWithDefault/{id}")
    public String matrixValueWithDefault(@MatrixParam(value = "value") @DefaultValue("8888") Integer value) {
        return value.toString();
    }

    @GET
    @Path("/matrixValues/{id}")
    public String matrixValues(@MatrixParam("value") List<Integer> values) {
        return values.toString();
    }

    @GET
    @Path("/matrixValuesWithDefault/{id}")
    public String matrixValuesWithDefault(@MatrixParam(value = "value") @DefaultValue("8888") List<Integer> values) {
        return values.toString();
    }
}
