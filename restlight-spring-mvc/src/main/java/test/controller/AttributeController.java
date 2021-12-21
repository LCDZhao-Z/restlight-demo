package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestAttribute;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @GetMapping("/attr")
    public String attribute(@RequestAttribute("value") Integer value) {
        System.out.println(value);
        return value.toString();
    }

}
