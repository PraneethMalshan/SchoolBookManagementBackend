package com.kdpm.schoolTextbookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "grade")
    private String grade;

    @Column(name = "subject_stream")
    private String subjectStream;

    @Column(name = "class_name")
    private String className;

    @Column(name = "student_image")
    private String studentImage;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Column(name = "book_allocations")
    private List<BookAllocation> bookAllocations;


}
