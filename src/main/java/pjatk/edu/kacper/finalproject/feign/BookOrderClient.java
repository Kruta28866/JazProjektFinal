package pjatk.edu.kacper.finalproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pjatk.edu.kacper.finalproject.bookshop.dto.PostOrderReportRequest;

import java.util.List;

@FeignClient(name = "book-order", url = "localhost:8081")
public interface BookOrderClient {


    @PostMapping("/api/order/report")
    void sendOrderReport(@RequestBody List<PostOrderReportRequest> request);


}
