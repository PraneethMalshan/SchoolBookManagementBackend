package com.kdpm.schoolTextbookManagement.dto;

import lombok.NoArgsConstructor;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private int bookId;
    private String title;
    private String subject;
    private String grade;
    private int totalCount;
    private int availableCount;
    private LocalDate receivedDate;
    private String bookImage;
}
