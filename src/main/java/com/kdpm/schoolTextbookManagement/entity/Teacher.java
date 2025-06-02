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
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "grade")
    private String grade;

    @Column(name = "teacher_image")
    private String teacherImage;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @Column(name = "book_allocations")
    private List<BookAllocation> bookAllocations;

}
