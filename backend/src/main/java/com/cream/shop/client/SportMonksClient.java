package com.cream.shop.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sportmonks", url = "${sportmonks.base.url}")
public interface SportMonksClient {

    @GetMapping("/fixtures?api_token={token}")
    Map<String, Object> getFixtures(@PathVariable("token") String token);
}
