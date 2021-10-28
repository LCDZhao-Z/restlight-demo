/*
 * Copyright 2020 OPPO ESA Stack Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.controller;

import esa.httpserver.core.AsyncRequest;
import esa.httpserver.core.AsyncResponse;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ChunkedController
 *
 * @author duanwei
 */
@RestController
@RequestMapping("/chunked")
public class ChunkedController {

    private static final int MB = 1024 * 1024;

    private static final byte[] BODY = new byte[1024 * 1024];

    static {
        ThreadLocalRandom.current().nextBytes(BODY);
    }

    @RequestMapping("/")
    public void handle(AsyncRequest request, AsyncResponse response) {
        if (request.body().length != MB) {
            System.err.println("Unexpected request body size: " + request.body().length);
        }

        response.sendResult(202, BODY);
    }
}
