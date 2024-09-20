package org.cheesecake.xrage.conroller;

import org.cheesecake.xrage.auth.rights.RequiresRights;
import org.cheesecake.xrage.auth.rights.Rights;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help")
public class TestRestController {

    @GetMapping
    public String test() {
        return "test";
    }

    @RequiresRights(Rights.ADMIN)
    @GetMapping("/admin")
    public String hey() {
        return "11000111000101001001011";
    }
}
