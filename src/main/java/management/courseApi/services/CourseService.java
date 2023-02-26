package management.courseApi.services;

import lombok.RequiredArgsConstructor;
import management.courseApi.models.Course;
import management.courseApi.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    public final CourseRepository courseRepository;
    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id) {
       return courseRepository.findById(id);
    }

    @Transactional
    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Transactional
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
