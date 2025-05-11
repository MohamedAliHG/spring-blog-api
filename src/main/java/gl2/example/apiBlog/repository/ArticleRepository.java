package gl2.example.apiBlog.repository;

import gl2.example.apiBlog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByAuthor(String author);
    List<Article> findByTitle(String title);
    List<Article> findByAuthorAndTitle(String author, String title);
    Article findById(Long id);

}
