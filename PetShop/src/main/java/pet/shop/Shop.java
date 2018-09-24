package pet.shop;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Shop {
    ArrayList<Product> products;

    public Shop() {
        products = new ArrayList<Product>();
        initProducts();
    }

    public ArrayList<Product> findProduct(String description) {
        ArrayList<Product> select = new ArrayList<Product>();

        for (Product p: products){
            if (p.description.contains(description)){
                select.add(p);
            }
        }

        return select;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void buyProduct(Product p) {
        products.get(products.indexOf(p)).inStock = false;
    }


    public void initProducts(){
        addProduct(new Product("Сухой корм для щенков малых пород 2-10 мес.", new BigDecimal("1800"), new BigDecimal("60")));
        addProduct(new Product("Сухой корм для щенков крупных пород 2-15 мес.", new BigDecimal("4500"), new BigDecimal("150")));
        addProduct(new Product("Сухой корм для щенков карликовых пород", new BigDecimal("1200"), new BigDecimal("40")));
        addProduct(new Product( "Паучи для пуделя (паштет)", new BigDecimal("60"), new BigDecimal("1")));
    }
}
