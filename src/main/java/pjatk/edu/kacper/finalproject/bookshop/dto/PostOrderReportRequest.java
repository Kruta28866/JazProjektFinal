package pjatk.edu.kacper.finalproject.bookshop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostOrderReportRequest {
    private long bookId;
    private int quantity;
    private String title;
}
