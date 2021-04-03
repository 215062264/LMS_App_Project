package ac.za.controller.basicAuth;

import ac.za.domain.AuthenticationBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated");
    }
}