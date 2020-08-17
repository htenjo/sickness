package co.zero.sickness.controller;

import co.zero.sickness.model.report.Report;
import co.zero.sickness.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/report1")
    public Mono<Report> getReport1() {
        return reportService.buildReport1(2020);
    }
}
