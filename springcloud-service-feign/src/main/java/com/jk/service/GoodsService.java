package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface GoodsService extends GoodsServiceApi{
}
