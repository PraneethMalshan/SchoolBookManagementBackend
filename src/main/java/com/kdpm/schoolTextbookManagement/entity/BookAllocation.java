package com.kdpm.schoolTextbookManagement.entity;

import com.kdpm.schoolTextbookManagement.entity.enums.AllocationStatus;
import com.kdpm.schoolTextbookManagement.entity.enums.AllocationTo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book_allocations")
public class BookAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocation_id")
    private Long allocationId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    @Column(name = "allocation_to")
    private AllocationTo allocationTo;  //STUDENT, TEACHER

    @Column(name = "allocated_date")
    private LocalDate allocatedDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "allocation_status")
    private AllocationStatus status;  // ALLOCATED, RETURNED, LOST, DAMAGED
}
