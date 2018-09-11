/**
 * @see  RestTemplate 基础配置类
 * @date 2018-02-27
 * @author scott
 * @company 益彩网络科技有限公司
 * @version v1.0
 */
package com.hhly.lottomsg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



@Configuration
public class RestTemplateConfig {

        @Bean
        public RestTemplate restTemplate(ClientHttpRequestFactory factory){
                     return new RestTemplate(factory);
        }

        @Bean
        public ClientHttpRequestFactory clientHttpRequestFactory(){
            SimpleClientHttpRequestFactory  factory = new SimpleClientHttpRequestFactory();
            factory.setReadTimeout(5000);
            factory.setConnectTimeout(15000);
            return factory ;
        }

}
