package pradooguilherme.springboot_coffee_api.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateProductRequest.class, name = "PRODUCT"),
        @JsonSubTypes.Type(value = CreateBarProductRequest.class, name = "BAR")
})
public sealed interface CreateProductBaseRequest permits CreateProductRequest, CreateBarProductRequest {
}
