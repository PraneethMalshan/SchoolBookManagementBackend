package com.kdpm.schoolTextbookManagement.repository;

import com.kdpm.schoolTextbookManagement.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findStudentByStudentId(int studentId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.studentId =:studentId")
    void deleteStudentByStudentId(int studentId);
}
