package management.courseApi.controllers;

import lombok.RequiredArgsConstructor;
import management.courseApi.models.Topic;
import management.courseApi.services.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;
    //get all topic
    @RequestMapping(method = RequestMethod.GET, value = "/courses/{id}/topics")
    public List<Topic> getAllTopic(@PathVariable String id){
        return topicService.getAllTopic(id);
    }

    @RequestMapping("/courses/{courseId/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }


//    @PostMapping( "/courses/{courseId}/topics")
//    public void addTopic(@RequestBody Topic topic, @PathVariable String courseId){
//        topicService.addTopic(topic, courseId);
//    }
//    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{courseId}/topics/{id}")
//    public void updateTopic(@RequestBody Topic topic, @PathVariable String courseId){
//        topicService.updateTopic(topic, courseId);
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}