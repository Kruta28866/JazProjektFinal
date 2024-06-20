package pjatk.edu.kacper.finalproject.bookshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.edu.kacper.finalproject.bookshop.dto.PostOrderReportRequest;
import pjatk.edu.kacper.finalproject.bookshop.repository.BookRepository;
import pjatk.edu.kacper.finalproject.feign.BookOrderClient;

@Service
public class ReportService {

    private final BookOrderClient bookOrderClient;
    private final BookRepository bookRepository;


    @Autowired
    public ReportService(BookOrderClient bookOrderClient, BookRepository bookRepository) {
        this.bookOrderClient = bookOrderClient;
        this.bookRepository = bookRepository;

    }

    public void sendReport() {


        var report = bookRepository.findAllBooks().stream()
                .map(book -> PostOrderReportRequest.builder()
                        .bookId(book.getId())
                        .title(book.getTitle())
                        .entries(book.getEntries() / 10)
                        .build())
                .toList();

        bookOrderClient.sendOrderReport(report);
    }

}

