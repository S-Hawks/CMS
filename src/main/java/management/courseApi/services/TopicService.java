package management.courseApi.services;

import lombok.RequiredArgsConstructor;
import management.courseApi.models.Topic;
import management.courseApi.repositories.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    public List<Topic> getAllTopic(String id) {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findCourseById(id).forEach(topics::add);
        return topics;
    }


    public final TopicRepository topicRepository;

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
    }

//    public void updateTopic(Topic topic, String courseId) {
//        topic.setCourse(new Course(courseId, " ", ""));
//        topicRepository.save(topic);
//    }
//
//    public void addTopic(Topic topic, String courseId) {
//        topic.setCourse(new Course(courseId, " ", " "));
//        topicRepository.save(topic);
//    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
