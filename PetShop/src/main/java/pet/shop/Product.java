package pet.shop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
public class Product {
    String description;
    String id;
    BigDecimal priceRUB;
    BigDecimal priceUSD;
    boolean inStock;

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public BigDecimal getPriceRUB() {
        return priceRUB;
    }

    @XmlElement
    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    @XmlElement
    public boolean isInStock() {
        return inStock;
    }

    public Product(String d, String id, BigDecimal rub, BigDecimal usd) {
        description = d;
        this.id = id;
        priceRUB = rub;
        priceUSD = usd;
        inStock = true;
    }

    @Override
    public String toString() {
        return "Product [description=" + description + ", id=" + id + ", RUB=" + priceRUB + ", USD=" + priceUSD + ", In stock=" + inStock + "]";
    }
}

