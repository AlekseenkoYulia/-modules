package service.soap;

import pet.shop.Exceptions.ProductNotFoundException;
import pet.shop.Product;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "service.soap.PetShopSoapServiceInterface")
public class PetShopSoapService implements PetShopSoapServiceInterface {

    @Override
    public String welcome() {
        return "Welcome to Pet Shop!";
    }

    @Override
    public String findProductsByDescription(String description) {
        try {
            ArrayList<Product> products = petShop.findProductsByDescription(description);
            return products.toString();
        } catch (ProductNotFoundException e) {
            return  "Product not found";
        }
    }

    @Override
    public String findProductById(String id) {
        try {
            Product product = petShop.findProductById(id);
            return product.toString();
        } catch (ProductNotFoundException e) {
            return "Product not found";
        }
    }

    @Override
    public String addProduct(String description, String id, Double rub, Double usd) {
        String status = petShop.addProduct(description, id, rub, usd);
        return status;
    }

    @Override
    public String buyProductById(String id) {
        String status = petShop.buyProductById(id);
        return status;
    }

    @Override
    public String buyProductByDescription(String description) {
        String status = petShop.buyProductById(description);
        return status;
    }
}
