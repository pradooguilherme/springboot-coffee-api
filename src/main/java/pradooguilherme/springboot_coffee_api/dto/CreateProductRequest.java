package pradooguilherme.springboot_coffee_api.dto;

public record CreateProductRequest(
        String name,
        String description,
        Double price
) implements CreateProductBaseRequest {
}
