package thinking.in.spring.boot.firstappbygui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ranyk
 */
@Slf4j
@RestController
//@Configuration
//@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = {"thinking.in.spring.boot.config"}) //same as @Configuration @ComponentScan @EnableAutoConfiguration
public class FirstAppByGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class, args);
        //    SpringApplication.run(WebConfiguration.class, args);
    }

    @GetMapping("/")
    public String defaultIndex() {
        return "redirect:index";
    }

    @GetMapping("/index")
    public String index() {
        return "hello world!";
    }


}
