package co.zero.sickness.web;

import co.zero.sickness.model.report.Report;
import co.zero.sickness.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class HomeController {
    private final ReportService reportService;

    @GetMapping("/report1")
    public Mono<Report> getHome() {
        return reportService.buildReport1(2020);
    }


}