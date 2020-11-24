package thinking.in.spring.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * ClassName:WebConfiguration
 * Description:配置类
 *
 * @author ranyi
 * @date 2020-11-23 23:03
 * Version: V1.0
 */
@Slf4j
//@Configuration
@SpringBootApplication
public class WebConfiguration {

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
