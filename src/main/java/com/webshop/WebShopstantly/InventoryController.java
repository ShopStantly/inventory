package com.webshop.WebShopstantly;

import com.webshop.WebShopstantly.internal.InventoryService;
import com.webshop.WebShopstantly.internal.Article;
import com.webshop.WebShopstantly.internal.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(path = "successful-order", method = RequestMethod.POST)
    public ResponseEntity<String> successfulOrder(@RequestBody Article articleToReduce) {
        articleService.reduceStockOfArticle(articleToReduce, 1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
