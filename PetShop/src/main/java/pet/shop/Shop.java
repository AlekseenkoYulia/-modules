package pet.shop;

import pet.shop.Exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Shop {
    ArrayList<Product> products;

    public Shop() {
        products = new ArrayList<Product>();
        initProducts();
    }

    public String test() {
        return "Test success";
    }

    public ArrayList<Product> findProductByDescription(String description) throws ProductNotFoundException {
        ArrayList<Product> select = new ArrayList<Product>();

        for (Product p : products) {
            if (p.description.contains(description)) {
                select.add(p);
            }
        }
        if (select.size() > 0) {
            return select;
        }
        throw new ProductNotFoundException();
    }

    public Product findProductById(String id) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        throw new ProductNotFoundException();
    }

    public String addProduct(String description, String id, BigDecimal rub, BigDecimal usd) {
        if (rub == null && usd == null) {
            return "You should add price";
        }
        if (rub == null) {
            rub = usd.multiply(new BigDecimal("30.00"));
        }

        if (usd == null) {
            usd = rub.divide(new BigDecimal("30.00"));
        }

        if (usd.multiply(new BigDecimal("30.00")).compareTo(rub) != 0) {
            return "Cannot add product. RUB price is not equals to USD price";
        }
        if (id.length() < 8 || id.length() > 10) {
            return "Cannot add product. Product ID must be 8-10 digits";
        }

        try {
            findProductById(id);
            return "Product is already in PetShop";
        } catch (ProductNotFoundException ex) {
        }

        Product product = new Product(description, id, rub, usd);
        products.add(product);

        System.out.println(this);

        return "Add product: success!";
    }

    public String buyProduct(String id) {
        try {
            Product select = findProductById(id);
            if (select.isInStock()) {
                select.setInStock(false);
                return "Buy product: success!";
            } else {
                return "Product out of stock";
            }
        } catch (ProductNotFoundException e) {
            return "Product not found";
        }
    }


    public void initProducts() {
        addProduct("JustFoodForDogs Fresh-on-the-Go Beef and Russet Potato Dog Food", "00000000", new BigDecimal("165"), new BigDecimal("5.5"));
        addProduct("JustFoodForDogs Fresh-on-the-Go Chicken and White Rice Dog Food", "00000001", new BigDecimal("150"), new BigDecimal("5"));
        addProduct("Kiwi Kitchens Super Food Booster Fish Recipe for Cats & Dogs", "00000002", new BigDecimal("390"), new BigDecimal("13"));
        addProduct("Kiwi Kitchens Lamb Liver Freeze Dried Dog Treats", "00000003", new BigDecimal("600"), new BigDecimal("20"));
    }

    @Override
    public String toString() {
        String result = "";

        for (Product p : products)
            result += p + "\n";
        return result;
    }
}
