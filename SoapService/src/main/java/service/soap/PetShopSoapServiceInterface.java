package service.soap;

import pet.shop.Shop;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PetShopSoapServiceInterface {
    static Shop petShop = new Shop();

    @WebMethod
    String welcome();

    @WebMethod
    String findProductsByDescription(String description);

    @WebMethod
    String findProductById(String id);

    @WebMethod
    String addProduct(String description, String id, Double rub, Double usd);

    @WebMethod
    String buyProductById(String id);

    @WebMethod
    String buyProductByDescription(String description);
}
