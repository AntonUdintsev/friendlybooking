package friendlybooking.mvp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WelcomeController {

    @GetMapping()
    public String welcome() {
        return "Welcome";
    }
}