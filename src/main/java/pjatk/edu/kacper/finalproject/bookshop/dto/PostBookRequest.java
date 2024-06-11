package pjatk.edu.kacper.finalproject.bookshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostBookRequest {

    @NotBlank
    @Size(min = 3, max = 32, message = "Genere letters must be between 3 - 32 ")
    private String genere;
    @NotBlank
    @Size(min = 3, max = 32, message = "Title letters must be between 3 - 32 ")
    private String title;
    @NotNull
    private double price;
    @NotNull
    private int pages;
    @NotNull
    private int quantity;
    @NotNull
    private Long authorId;

}
