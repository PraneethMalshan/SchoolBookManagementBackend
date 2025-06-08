package com.kdpm.schoolTextbookManagement.repository;

import com.kdpm.schoolTextbookManagement.entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    Teacher getReferenceById(int teacherId);

    List<Teacher> findTeacherByTeacherId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Teacher t WHERE t.teacherId =:teacherId")
    void deleteTeacherByTeacherId(int teacherId);

}
