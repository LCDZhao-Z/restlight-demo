package test.controller;

import esa.commons.collection.MultiValueMap;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.MatrixVariable;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    @GetMapping("/singleMap/{id}")
    public String singleMap(@MatrixVariable Map<String, String> singleMap) {
        System.out.println(singleMap);
        return singleMap.toString();
    }

    @GetMapping("/multiMap/{id}")
    public String multiMap(@MatrixVariable MultiValueMap<String, String> multiMap) {
        System.out.println(multiMap);
        return multiMap.toString();
    }

    @GetMapping("/matrixValue/{id}")
    public String matrixValue(@MatrixVariable("value") Integer value) {
        return value.toString();
    }

    @GetMapping("/matrixValueWithDefault/{id}")
    public String matrixValueWithDefault(@MatrixVariable(value = "value", defaultValue = "8888") Integer value) {
        return value.toString();
    }

    @GetMapping("/matrixValues/{id}")
    public String matrixValues(@MatrixVariable("value") List<Integer> values) {
        return values.toString();
    }

    @GetMapping("/matrixValuesWithDefault/{id}")
    public String matrixValuesWithDefault(@MatrixVariable(value = "value", defaultValue = "8888") List<Integer> values) {
        return values.toString();
    }
}
