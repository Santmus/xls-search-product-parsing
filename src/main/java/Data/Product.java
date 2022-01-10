package Data;

import Application.XLSWritter;
import lombok.Getter;

@Getter
public class Product {

    private final long ufc;
    private final int count;
    private final float price;

    public Product(long ufc, int count, float price){
        ++XLSWritter.rowNum;

        this.ufc = ufc;
        this.count = count;
        this.price = price;

    }

}
