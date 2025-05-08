package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity  //Entity ekak kiyala pennanna mee annotation eka daanawa.
@Table(name="subject")  //DB Table eke name eka change kara ganna oona nam mee annotation eka use karnna puluwan.
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id", length = 45)  //database ekee column ekee hadena name eka custurmize kara ganna puluwan mee annotation eken. saha  validation ekak dennath puluwan.
    private long SubjectId;

    @Column(name = "subject_name", length = 45)
    private String subjectName;

    @OneToMany(mappedBy = "subject")
    private Set<Book> book;

}
