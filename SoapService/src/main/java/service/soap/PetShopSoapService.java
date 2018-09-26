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
    public String findProductByDescription(String description) {
        try {
            ArrayList<Product> select = petShop.findProductByDescription(description);
            return select.toString();
        } catch (ProductNotFoundException e) {
            return  "Product not found";
        }
    }

    @Override
    public String findProductById(String id) {
        try {
            Product select = petShop.findProductById(id);
            return select.toString();
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
    public String buyProduct(String id) {
        String status = petShop.buyProduct(id);
        return status;
    }
}
