package pjatk.edu.kacper.finalproject.bookshop.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pjatk.edu.kacper.finalproject.bookshop.entity.Author;

import java.util.HashSet;
import java.util.Set;
//Książka powinna zawierać:
//Autora, Gatunek, Cenę, Ilość stron, licznik odwiedzin, oraz informację czy jest dostępna (ile sztuk).
//Autor powinien być osobną klasą, encją bazodanową.
//Książka, po jej wyszukaniu powinna inkrementować ilość odwiedzin.
@Getter
@Setter
@Builder
public class PostBookRequest {

    @NotBlank
    @Size(min = 3,max = 32, message = "Genere letters must be between 3 - 32 ")
    private String genere;
    @NotBlank
    @Size(min = 3,max = 32, message = "Title letters must be between 3 - 32 ")
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
