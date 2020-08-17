package co.zero.sickness.service;

import co.zero.sickness.model.report.Report;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReportService {
    public Mono<Report> buildReport1(int year) {
        return Mono.just(buildExampleReport());
    }

    Report buildExampleReport() {
        Report report = new Report();
        report.setTitle("Report 1");
        report.setSubtitle("Additional information for the report");
        report.addColumnDefinition(new Report.ColumnDefinition("1", "Year", "string"));
        report.addColumnDefinition(new Report.ColumnDefinition("2", "Sales", "number"));
        report.addColumnDefinition(new Report.ColumnDefinition("3", "Expenses", "number"));
        report.addColumnDefinition(new Report.ColumnDefinition("4", "Profit", "number"));
        report.addDataRow("1", List.of("2014", 1000, 400, 200));
        report.addDataRow("2", List.of("2015", 1170, 460, 250));
        report.addDataRow("3", List.of("2016", 660, 1120, 300));
        report.addDataRow("4", List.of("2017", 1030, 540, 350));
        return report;
    }
}
