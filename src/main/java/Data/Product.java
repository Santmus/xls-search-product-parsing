package Data;

import lombok.*;

@Getter

public class Product {

    private final String ufc;
    private final String count;
    private final String price;

    public Product(String ufc, String count, String price){
        this.ufc = ufc;
        this.count = count;
        this.price = price;
    }

}
