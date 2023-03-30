//package com.alok.gateway.gateway.filters;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;
//
//@Component
//public class CustomRewritePathGatewayFilterFactory implements GatewayFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest req = exchange.getRequest();
//        addOriginalRequestUrl(exchange, req.getURI());
//        String path = req.getURI().getRawPath();
//        String newPath = path.replaceAll("/olb/(?<segment>/?.*)", "/${segment}");
//        ServerHttpRequest request = exchange.getRequest().mutate().path(newPath).build();
//        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, request.getURI());
//        return chain.filter(exchange.mutate().request(request).build());
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
