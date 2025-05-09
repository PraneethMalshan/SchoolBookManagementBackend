package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="academic_year")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicYear {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "academic_year_id", length = 45)
    private long academicYearId;

    @Column(name = "academic_year", length = 45)
    private String academicYear;

    @OneToMany(mappedBy = "academicYear")
    private Set<Book> book;
}
