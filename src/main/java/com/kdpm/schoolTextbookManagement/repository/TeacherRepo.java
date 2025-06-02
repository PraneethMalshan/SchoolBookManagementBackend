package com.kdpm.schoolTextbookManagement.repository;

import com.kdpm.schoolTextbookManagement.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
}
