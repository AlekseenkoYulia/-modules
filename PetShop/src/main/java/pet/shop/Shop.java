package pet.shop;

import pet.shop.Exceptions.ProductNotFoundException;

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
            if (p.description.toLowerCase().contains(description.toLowerCase())) {
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

    public String addProduct(String description, String id, Double rub, Double usd) {
        System.out.println("rub: " + rub);
        System.out.println("usd: " + usd);
        if (rub == null && usd == null) {
            return "You should add price";
        }
        if (rub == null) {
            rub = usd * 30;
            System.out.println("rub: " + rub);
        }

        if (usd == null) {
            usd = rub / 30;
            System.out.println("usd: " + usd);
        }

        if (usd*30 != rub) {
            return "Cannot add product. RUB price is not equals to USD price";
        }
        if (id.length() < 8 || id.length() > 10) {
            return "Cannot add product. Product ID must be 8-10 digits";
        }

        for (Product p : products) {
            if (p.id.equals(id) || p.description.toLowerCase().equals(description.toLowerCase())) {
                return "Product is already in PetShop";
            }
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
        addProduct("JustFoodForDogs Fresh-on-the-Go Beef and Russet Potato Dog Food", "00000000", new Double("165"), new Double("5.5"));
        addProduct("JustFoodForDogs Fresh-on-the-Go Chicken and White Rice Dog Food", "00000001", new Double("150"), new Double("5"));
        addProduct("Kiwi Kitchens Super Food Booster Fish Recipe for Cats & Dogs", "00000002", new Double("390"), new Double("13"));
        addProduct("Kiwi Kitchens Lamb Liver Freeze Dried Dog Treats", "00000003", new Double("600"), new Double("20"));
    }

    @Override
    public String toString() {
        String result = "";

        for (Product p : products)
            result += p + "\n";
        return result;
    }
}
