package management.courseApi.controllers;

import lombok.RequiredArgsConstructor;
import management.courseApi.models.Course;
import management.courseApi.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CourseController {
    public final CourseService courseService;
    @RequestMapping("/courses")
    public List<Course> getAllCourse()
    {
        return courseService.getAllCourse();

    }
    @RequestMapping("/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);

    }

}
