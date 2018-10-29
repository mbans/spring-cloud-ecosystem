package com.mbans.sandbox.springcloud.product;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by lumarmacy1 on 29/10/2018.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductProperties properties;

    @RequestMapping("/product/{product}")
    public String getProduct(@PathVariable String product) {
        return Optional.ofNullable(properties.getProduct(product)).orElse("Invalid product " + product);
    }

    @Component
    public static class ProductProperties implements InitializingBean {

        @Value("${trousers}")
        private String trousers;

        @Value("${shirt}")
        private String shirt;

        @Value("${shoes}")
        private String shoes;

        private Map<String,String> properties = new HashMap();

        public ProductProperties() {
        }

        public String getProduct(final String product) {
            return properties.get(product);
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            properties.put("trousers",trousers);
            properties.put("shirt",shirt);
            properties.put("shoes",shoes);
        }
    }
}
