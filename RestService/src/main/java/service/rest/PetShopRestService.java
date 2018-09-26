package service.rest;

import pet.shop.Exceptions.ProductNotFoundException;
import pet.shop.Product;
import pet.shop.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/shop")
public class PetShopRestService {
    static Shop petShop = new Shop();

    @GET
    public Response welcome() {
        return Response.status(200).entity("Welcome to Pet Shop!").build();
    }


    @GET
    @Path("/search/{description}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findProductByDescription(@PathParam("description") String description) {
        try {
            ArrayList<Product> select = petShop.findProductByDescription(description);
            return Response.status(200).entity(select).build();
        } catch (ProductNotFoundException e) {
            return Response.status(404).entity("Product not found").build();
        }
    }

    @GET
    @Path("/search/{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findProductById(@PathParam("id") String id) {
        try {
            Product select = petShop.findProductById(id);
            return Response.status(200).entity(select).build();
        } catch (ProductNotFoundException e) {
            return Response.status(404).entity("Product not found").build();
        }
    }

    @POST
    @Path("/add/{description}/{id}")
    public Response addProduct(
            @PathParam("description") String description,
            @PathParam("id") String id,
            @MatrixParam("rub") Double rub,
            @MatrixParam("usd") Double usd) {

        String status = petShop.addProduct(description, id, rub, usd);
        return Response.status(200).entity(status).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducts(Product[] products){
        StringBuilder responseMsg = new StringBuilder();
        for (Product p: products){
            String status = petShop.addProduct(p.getDescription(), p.getId(), p.getPriceRUB(), p.getPriceUSD());
            if (!status.equals("Add product: success!")){
                responseMsg.append("Can't add product: " + p + "\n" + status +"\n");
            }
        }

        return Response.status(200).entity(responseMsg.append("Operation complete.")).build();
    }

    @GET
    @Path("/buy/{id: \\d+}")
    public Response buyProduct(@PathParam("id") String id) {
        String status = petShop.buyProduct(id);
        return Response.status(200).entity(status).build();
    }
}