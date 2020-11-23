package thinkinginspringboot.firstappbyapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author ranyk
 */
@Slf4j
@RestController
//@SpringBootApplication //same as @Configuration @ComponentScan @EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableAutoConfiguration
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

    @Bean
    public RouterFunction<ServerResponse> hellWorld(){
        return route(GET("/hello-world"),request -> ok().body(Mono.just("Hello,World!"),String.class));
    }

    /*@Bean
    public ApplicationRunner runner(WebServerApplicationContext context){
        return args -> {
            log.error("当前 WebServer 实现类为: " + context.getWebServer().getClass().getName());
        };
    }*/

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        log.error("当前 WebServer 实现类为: " + event.getWebServer().getClass().getName());
    }


}
