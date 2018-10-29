package com.mbans.sandbox.springcloud.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lumarmacy1 on 29/10/2018.
 */
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceProperties properties;

    @RequestMapping("/{product}")
    public String getPrice(@PathVariable String product) {
        String price = properties.getPrice(product);
        if(price == null) {
            return "No price for " + product;
        }
        return product + " costs £"  + price;
    }

}
