package  com.pooja.model;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    private String city;

    @NotBlank(message = "Location should be valid")
    private String location;


    @Size(min = 100, max = 500, message = "Seating capacity should be between 4 and 20 characters")
    private Integer seating_capacity;
}

