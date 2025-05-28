package com.kdpm.schoolTextbookManagement.dto;

import com.kdpm.schoolTextbookManagement.entity.enums.AllocationStatus;
import com.kdpm.schoolTextbookManagement.entity.enums.AllocationTo;

import java.time.LocalDate;

public class BookAllocationDTO {
    private Long allocationId;
    private Long bookId;
    private Long studentId;
    private Long teacherId;
    private AllocationTo allocationTo;
    private LocalDate allocatedDate;
    private LocalDate returnDate;
    private AllocationStatus status;
}
