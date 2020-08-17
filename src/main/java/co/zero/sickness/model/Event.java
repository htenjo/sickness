package co.zero.sickness.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("events")
public class Event {
    @Id
    private Long id;
    @Column("no_pers")
    private String noPers;
    private String nombre;
    private String division;
    private String subdivision;
    private LocalDate desde;
    private LocalDate hasta;
    @Column("cl_ab_pre")
    private String clAbPre;
    private String clase;
    @Column("dia_nat")
    private int diaNat;
    private String jefe;
    private String sociedad;
    private String nif;
    private String posicion;
    private String codigo;
    private String enfermedad;
    private String administrador;
    @Column("division_fi")
    private String divisionFi;
    @Column("centro_coste")
    private String centroCoste;
    @Column("unidad")
    private String unidad;
    @Column("clave_org")
    private String claveOrg;
    private String agr;
}