package pjatk.edu.kacper.finalproject.bookshop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetBookResponse {

    private String genere;
    private String title;
    private double price;
    private int pages;
    private String authorName;
}
