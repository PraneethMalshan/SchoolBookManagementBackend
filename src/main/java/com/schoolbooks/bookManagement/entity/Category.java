package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity  //Entity ekak kiyala pennanna mee annotation eka daanawa.
@Table(name="category")  //DB Table eke name eka change kara ganna oona nam mee annotation eka use karnna puluwan.
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", length = 45)
    private long categoryId;

    @Column(name = "category_name", length = 45)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Book> book;
}
