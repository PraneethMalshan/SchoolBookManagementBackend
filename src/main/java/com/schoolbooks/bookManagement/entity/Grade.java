package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity  //Entity ekak kiyala pennanna mee annotation eka daanawa.
@Table(name="grade")  //DB Table eke name eka change kara ganna oona nam mee annotation eka use karnna puluwan.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id  //Primary key ekak kiyala pennanna me annotation eka danawa
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id", length = 45)  //database ekee column ekee hadena name eka custurmize kara ganna puluwan mee annotation eken. saha  validation ekak dennath puluwan.
    private long gradeId;

    @Column(name = "grade_name", length = 45)
    private String gradeName;

    @OneToMany(mappedBy = "grade")
    private Set<Book> book;

}
