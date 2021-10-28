package demo.controller;

import esa.httpserver.core.AsyncRequest;
import esa.httpserver.core.AsyncResponse;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ThreadLocalRandom;

/**
 * HttpClientController
 *
 * @author duanwei
 * @date 2020/10/15 17:09
 */
@Controller
@RequestMapping("/simple")
public class SimpleReadWriteController {

    private static final byte[] BODY = new byte[1024 * 1024];

    static {
        ThreadLocalRandom.current().nextBytes(BODY);
    }

    @RequestMapping("/11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555" +
            "11111111112222222222333333333344444444445555555555")
    public void list(AsyncRequest request, AsyncResponse response) {
        if (request.body().length != BODY.length) {
            System.err.println("Unexpected body size: " + request.body().length);
        }
        response.sendResult(202, BODY);
    }

}
