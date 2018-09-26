package service.soap;

import pet.shop.Shop;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PetShopSoapServiceInterface {
    static Shop petShop = new Shop();

    @WebMethod
    public String welcome();

    @WebMethod
    public String findProductByDescription(String description);

    @WebMethod
    public String findProductById(String id);

    @WebMethod
    public String addProduct(String description, String id, Double rub, Double usd);

    @WebMethod
    public String buyProduct(String id);
}
