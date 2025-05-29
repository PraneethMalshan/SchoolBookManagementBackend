package com.kdpm.schoolTextbookManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "grade")
    private String grade;

    @Column(name = "total_count")
    private int totalCount;

    @Column(name = "available_count")
    private int availableCount;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "book_image")
    private String bookImage;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookAllocation> bookAllocations;

}
