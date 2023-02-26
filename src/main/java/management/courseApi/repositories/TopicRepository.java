package management.courseApi.repositories;

import management.courseApi.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
    List<Topic> findCourseById(String id);
}
