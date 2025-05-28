package com.kdpm.schoolTextbookManagement.dto;

import java.time.LocalDate;

public class BookDTO {
    private Long bookId;
    private String title;
    private String subject;
    private String grade;
    private int totalCount;
    private int availableCount;
    private LocalDate recievedDate;
    private String bookImage;
}
