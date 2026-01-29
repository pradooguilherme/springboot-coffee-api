package pradooguilherme.springboot_coffee_api.model;

import jakarta.persistence.*;

@Entity
public class BarProduct extends Product {

    @Column(name = "bar_product_final_price")
    private Double finalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "bar_product_size")
    private BarProductSize barProductSize;

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BarProductSize getBarProductSize() {
        return barProductSize;
    }

    public void setBarProductSize(BarProductSize barProductSize) {
        this.barProductSize = barProductSize;
    }
}
