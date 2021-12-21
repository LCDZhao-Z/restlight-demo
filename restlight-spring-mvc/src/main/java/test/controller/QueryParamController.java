package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestParam;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/queryParam")
public class QueryParamController {

    @GetMapping("/singleMap")
    public String singleMap(@RequestParam Map<String, String> singleMap) {
        System.out.println(singleMap);
        return singleMap.toString();
    }

    @GetMapping("/multiMap")
    public String multiMap(@RequestParam Map<String, List<String>> multiMap) {
        System.out.println(multiMap);
        return multiMap.toString();
    }

    @GetMapping("/value")
    public String value(@RequestParam("value") Integer value) {
        return value.toString();
    }

    @GetMapping("/valueDefault")
    public String valueDefault(@RequestParam(value = "value", defaultValue = "8888") Integer value) {
        return value.toString();
    }

    @GetMapping("/values")
    public String values(@RequestParam("value") List<Integer> values) {
        return values.toString();
    }

    @GetMapping("/valuesWithDefault")
    public String valuesWithDefault(@RequestParam(value = "value", defaultValue = "8888") List<Integer> values) {
        return values.toString();
    }
}
