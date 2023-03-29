package com.itmuch.appgateway.predicate;

import com.itmuch.appgateway.predicate.config.TimeBetweenConfig;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义谓词工厂类
 *
 * 注：类名一定要以"RoutePredicateFactory"结尾
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }


    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
           LocalTime now = LocalTime.now();
           return now.isAfter(start) && now.isBefore(end);
        };
//        return new Predicate<ServerWebExchange>() {
//            @Override
//            public boolean test(ServerWebExchange serverWebExchange) {
//               LocalTime now = LocalTime.now();
//               return now.isAfter(start) && now.isBefore(end);
//            }
//        };
    }

    /**
     * 处理配置文件中自定义谓词属性和配置类TimeBetweenConfig映射关系的方法
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder(){
        return Arrays.asList("start","end");
    }
}
