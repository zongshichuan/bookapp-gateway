package com.itmuch.appgateway.filterfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义gateway过滤器工厂
 *
 * 注：类名必须以"GatewayFilterFactory"结尾
 */
@Slf4j
@Component
public class PreLogGatewayFilterFactory  extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return ((exchange, chain) -> {
            log.info("请求进来自定义的gateway过滤器工厂了,{},{}",config.getName(),config.getValue());
            //被修改的请求
            ServerHttpRequest modifiedRequest = exchange.getRequest()
                    .mutate()
                    .build();
            //被修改的exchange
            ServerWebExchange modifiedExchange = exchange.mutate()
                    .request(modifiedRequest)
                    .build();
            return chain.filter(modifiedExchange);
        });
    }
}
