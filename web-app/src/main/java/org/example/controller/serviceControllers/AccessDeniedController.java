package org.example.controller.serviceControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("access/denied")
    public String pageAccesDenied() {
        return "exception/accessDenied";
    }
}