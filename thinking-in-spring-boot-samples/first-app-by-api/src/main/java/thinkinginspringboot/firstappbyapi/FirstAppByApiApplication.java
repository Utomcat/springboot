package thinkinginspringboot.firstappbyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ranyk
 */
@RestController
@SpringBootApplication
public class FirstAppByApiApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppByApiApplication.class, args);
    }

    @GetMapping("/")
    public String defaultIndex(){
        return "redirect:index";
    }

    @GetMapping("/index")
    public String index(){
        return "hello world!";
    }


}
