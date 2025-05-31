package com.kdpm.schoolTextbookManagement.dto.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookUpdateDTO {
    private int bookId;
    private String title;
    private String subject;
    private String grade;
    private int totalCount;
    private int availableCount;
    private LocalDate receivedDate;
    private String bookImage;
}
