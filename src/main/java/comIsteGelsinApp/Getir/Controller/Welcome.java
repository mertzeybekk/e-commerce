package comIsteGelsinApp.Getir.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Welcome {
    @GetMapping("/welcome")
    public String welcome(){
        return  "selam";
    }
}
