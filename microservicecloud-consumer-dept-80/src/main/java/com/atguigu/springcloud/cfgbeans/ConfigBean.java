package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 */
@Configuration
public class ConfigBean {   //类似spring里面的applicationContext.xml写入的注入Bean

    @Bean
    @LoadBalanced   //加入负载均衡的配置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //return new RandomRule();//达到的目的是用随机算法替换轮询算法
        return new RetryRule(); //先按照轮询的方式获取服务，如果服务有问题在碰撞到多次后会跳过有问题的微服务
    }
}
