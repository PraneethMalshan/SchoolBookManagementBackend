package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.Flow;

@Entity  //Entity ekak kiyala pennanna mee annotation eka daanawa.
@Table(name="book")  //DB Table eke name eka change kara ganna oona nam mee annotation eka use karnna puluwan.
@Data
//@Builder
public class Book {

    @Id  //Primary key ekak kiyala pennanna me annotation eka danawa
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", length = 100)  //database ekee column ekee hadena name eka custurmize kara ganna puluwan mee annotation eken. saha  validation ekak dennath puluwan.
    private long id;

    @Column(name = "book_name", length = 100, nullable = false)  //name ekak nathiwa table ekata customer kenek add karanna bh.. meeka nathuwa nm daanna puluwan. ee nisa null karanne nathuwa thiyanna.
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYear academicYear;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "remaining_quantity")
    private int remainingQuantity;

}
