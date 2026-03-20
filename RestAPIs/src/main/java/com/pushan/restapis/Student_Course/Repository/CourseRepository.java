package com.pushan.restapis.Student_Course.Repository;

import com.pushan.restapis.Student_Course.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
