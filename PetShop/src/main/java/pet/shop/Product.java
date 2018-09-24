package pet.shop;

import java.math.BigDecimal;

public class Product {
    String description;
    BigDecimal priceRUB;
    BigDecimal priceUSD;
    boolean inStock;

    public Product(String d, BigDecimal rub, BigDecimal usd){
        description = d;
        priceRUB = rub;
        priceUSD = usd;
        inStock = true;
    }
}

