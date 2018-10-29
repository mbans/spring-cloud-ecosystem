package com.mbans.sandbox.springcloud.price;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lumarmacy1 on 29/10/2018.
 */
@Component
public class PriceProperties implements InitializingBean {

    @Value("${price.trousers}")
    private String trousersPrice;

    @Value("${price.shoes}")
    private String shoesPrice;

    @Value("${price.shirt}")
    private String shirtPrice;

    private Map<String,String> prices = new HashMap();

    public PriceProperties() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        prices.put("trousers", trousersPrice);
        prices.put("shoes", shoesPrice);
        prices.put("shirt", shirtPrice);
    }

    public String getPrice(final String product) {
        return prices.get(product);
    }

}
