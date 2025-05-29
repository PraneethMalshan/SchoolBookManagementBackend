package com.kdpm.schoolTextbookManagement.dto;

import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackDTO {
    private Long feedbackId;
    private String userId;
    private String message;
    private LocalDateTime submittedAt;
}
