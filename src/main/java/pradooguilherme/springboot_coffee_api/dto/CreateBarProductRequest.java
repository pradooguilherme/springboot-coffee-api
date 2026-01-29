package pradooguilherme.springboot_coffee_api.dto;

import pradooguilherme.springboot_coffee_api.model.BarProductSize;

public record CreateBarProductRequest(
        String name,
        String description,
        Double price,
        BarProductSize barProductSize,
        Double finalPrice
) implements CreateProductBaseRequest {
}
