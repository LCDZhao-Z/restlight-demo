package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestHeader;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;
import io.esastack.commons.net.http.HttpHeaders;

import java.util.List;

@RestController
@RequestMapping("/header")
public class HeaderController {

    @GetMapping("/headers")
    public String header(@RequestHeader("headers") HttpHeaders headers) {
        headers.forEach((entry) -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
        return headers.toString();
    }

    @GetMapping("/headerValue")
    public String headerValue(@RequestHeader("value") Integer value) {
        return value.toString();
    }

    @GetMapping("/headerValueWithDefault")
    public String headerValueWithDefault(@RequestHeader(value = "value", defaultValue = "8888") Integer value) {
        return value.toString();
    }

    @GetMapping("/headerValues")
    public String headerValues(@RequestHeader("value") List<Integer> values) {
        return values.toString();
    }

    @GetMapping("/headerValuesWithDefault")
    public String headerValuesWithDefault(@RequestHeader(value = "value", defaultValue = "8888") List<Integer> values) {
        return values.toString();
    }

}
