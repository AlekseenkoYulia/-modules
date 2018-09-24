package service.rest;

import pet.shop.Product;
import pet.shop.Shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/rest")
public class PetShopRestService {

    @GET
    @Path("/test")
    public Response test(){
        Shop petShop = new Shop();
        return Response.status(200).entity(petShop.test()).build();
    }

//    @GET
//    @Path("/search/{description}")
//    public Response findProduct(@PathParam("description") String description){
//        Shop petShop = new Shop();
//        ArrayList<Product> select = petShop.findProduct(description);
//
//        return Response.status(200).entity(select).build();
//    }
}