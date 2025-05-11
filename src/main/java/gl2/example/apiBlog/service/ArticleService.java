package gl2.example.apiBlog.service;

import gl2.example.apiBlog.model.Article;
import gl2.example.apiBlog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public List<Article> getArticlesByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    public List<Article> getArticlesByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }

    public List<Article> getArticlesByAuthorAndTitle(String author, String title) {
        return articleRepository.findByAuthorAndTitle(author, title);
    }


    public void createArticle(Article article) {
        articleRepository.save(article);
    }

    public void deleteArticleById( Long id) {
        articleRepository.deleteById(Math.toIntExact(id));
    }


    public void updateArticle(Article newArticle) {articleRepository.save(newArticle);}

    public List<Article> searchArticles(Long searchId, String searchTitle, String searchAuthor) {
        if (searchId != null) {
            Article article = getArticleById(searchId);
            if (article != null) {
                List<Article> articles = new ArrayList<>();
                articles.add(article);
                return articles;
            } else {
                return new ArrayList<>();
            }
        }

        if (searchTitle != null && !searchTitle.isEmpty() && searchAuthor != null && !searchAuthor.isEmpty()) {
            return articleRepository.findByAuthorAndTitle(searchAuthor, searchTitle);
        }

        if (searchTitle != null && !searchTitle.isEmpty()) {
            return articleRepository.findByTitle(searchTitle);
        }

        if (searchAuthor != null && !searchAuthor.isEmpty()) {
            return articleRepository.findByAuthor(searchAuthor);
        }

        return articleRepository.findAll();
    }

}
