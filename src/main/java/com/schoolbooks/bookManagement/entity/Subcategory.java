package com.schoolbooks.bookManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="subcategory")
@Data
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subcategory_id", length = 45)
    private long subcategoryId;

    @Column(name = "subcategory_name", length = 45)
    private String subcategoryName;

    @OneToMany(mappedBy = "subcategory")
    private Set<Book> book;

}
