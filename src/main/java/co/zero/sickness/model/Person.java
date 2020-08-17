package co.zero.sickness.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    //@Id
    private String id;
    private String name;
    private LocalDate from;
    private LocalDate to;
}
