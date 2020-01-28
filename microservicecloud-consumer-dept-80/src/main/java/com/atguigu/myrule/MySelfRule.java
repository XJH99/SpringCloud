package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义负载均衡算法
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return new RandomRule();//达到的目的是用随机算法替换轮询算法
        //return new RetryRule(); //先按照轮询的方式获取服务，如果服务有问题在碰撞到多次后会跳过有问题的微服务

        return new RandomRule_ZY(); //自定义每台机器五次
    }

}
