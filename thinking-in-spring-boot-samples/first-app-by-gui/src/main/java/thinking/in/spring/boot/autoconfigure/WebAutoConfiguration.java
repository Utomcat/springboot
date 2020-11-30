package thinking.in.spring.boot.autoconfigure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import thinking.in.spring.boot.config.WebConfiguration;

/**
 * ClassName:WebAutoConfiguration
 * Description:自定义自动装配类
 *
 * @author ranyi
 * @date 2020-11-30 23:27
 * Version: V1.0
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
