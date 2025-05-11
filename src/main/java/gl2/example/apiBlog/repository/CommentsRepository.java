package gl2.example.apiBlog.repository;

import gl2.example.apiBlog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {


}
