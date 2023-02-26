package management.courseApi.controllers;

import lombok.RequiredArgsConstructor;
import management.courseApi.models.Course;
import management.courseApi.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CourseFrontController {
    private final CourseService courseService;

    @GetMapping(value = "/ui/courses")
    public String getAllCourse(Model model)
    {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("course", new Course());
        model.addAttribute("courses", courses);
        return "course";
    }
//    @GetMapping("/addCourse")
//    public String getCourseToAdd(Model model)
//    {
//        Course course = new Course();
//        model.addAttribute("course", course);
//        return "course";
//    }
    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("course") Course course){
        courseService.addCourse(course);
        return "redirect:/ui/courses";
    }

    //here We are mainly getting
    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable(value = "id") String id, Model model){
        Optional<Course> course = courseService.getCourse(id);
        model.addAttribute("course", course);
        return "update_course";
    }
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(value="id") String id)
    {
        this.courseService.deleteCourse(id);
        return "redirect:/ui/courses";
    }
    @GetMapping("/getTopics/{id}")
    public String getTopics(@PathVariable String id)
    {
//        this.courseService.deleteCourse(id);
        return "redirect:/ui/courses";
    }

}
