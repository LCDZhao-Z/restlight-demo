package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.PathVariable;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathVariable")
public class PathVariableController {

    @GetMapping("/{id}")
    public String singleMap(@PathVariable("id") String id) {
        System.out.println(id);
        return id.toString();
    }

}
