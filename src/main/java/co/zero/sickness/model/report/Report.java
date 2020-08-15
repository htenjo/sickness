package co.zero.sickness.model.report;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Report {
    private String title;
    private String subtitle;
    private List<ColumnDefinition> columnDefinitions = new ArrayList<>();
    private List<RowDefinition> rowDefinitions = new ArrayList<>();
    private Map<String, List<Object>> data = new LinkedHashMap<>();

    public void addColumnDefinition(ColumnDefinition columnDefinition) {
        columnDefinitions.add(columnDefinition);
    }

    public void addDataRow(String rowKey, List<Object> columnInfo) {
        data.put(rowKey, columnInfo);
    }

    @Getter
    @RequiredArgsConstructor
    public static class ColumnDefinition {
        private final String id;
        private final String label;
        private final String type;
        private String format;
    }

    @Getter
    @RequiredArgsConstructor
    public static class RowDefinition {
        private final String id;
        private final String label;
    }
}

