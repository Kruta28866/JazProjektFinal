package pjatk.edu.kacper.finalproject.bookshop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pjatk.edu.kacper.finalproject.bookshop.dto.GetBookResponse;
import pjatk.edu.kacper.finalproject.bookshop.dto.PostBookRequest;
import pjatk.edu.kacper.finalproject.bookshop.entity.Book;
import pjatk.edu.kacper.finalproject.bookshop.helper.BookHelper;
import pjatk.edu.kacper.finalproject.bookshop.services.AuthorService;
import pjatk.edu.kacper.finalproject.bookshop.services.BookService;
import pjatk.edu.kacper.finalproject.bookshop.services.ReportService;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookHelper bookHelper;

    private final BookService bookService;

    private final AuthorService authorService;

    private final ReportService reportService;


    @Autowired
    public BookController(BookHelper bookHelper, BookService bookService, AuthorService authorService, ReportService reportService) {
        this.bookHelper = bookHelper;
        this.bookService = bookService;
        this.authorService = authorService;
        this.reportService = reportService;
    }

    @GetMapping("{bookId}")
    public ResponseEntity<GetBookResponse> getBook(@PathVariable("bookId") Long bookId) {

        var book = bookService.getBookById(bookId);

        book.ifPresent(bookHelper::incrementEntry);

        return book.map(value -> ResponseEntity.ok(GetBookResponse.builder()
                        .title(value.getTitle())
                        .pages(value.getPages())
                        .price(value.getPrice())
                        .authorName(value.getAuthor().getName())
                        .genere(value.getGenere())
                        .build()))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());

    }

    @PostMapping
    public ResponseEntity<PostBookRequest> saveBook(@RequestBody @Valid PostBookRequest bookRequest,
                                                    BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        var book = Book.builder()
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .genere(bookRequest.getGenere())
                .pages(bookRequest.getPages())
                .quantity(bookRequest.getQuantity())
                .build();
        bookService.saveBook(book, bookRequest.getAuthorId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order-report")
    public ResponseEntity<Void> reportOrder() {
        reportService.sendReport();
        return ResponseEntity.noContent().build();
    }

    //TODO - każde wyswietlenie ma się indeksować
}
