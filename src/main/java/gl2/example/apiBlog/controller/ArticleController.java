package gl2.example.apiBlog.controller;


import gl2.example.apiBlog.model.Article;
import gl2.example.apiBlog.model.ArticleToCreate;
import gl2.example.apiBlog.model.Comments;
import gl2.example.apiBlog.service.ArticleService;
import gl2.example.apiBlog.service.CommentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/blog")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentsService commentsService;

    @GetMapping
    public String getAllArticles(@RequestParam(required = false) Long searchId,
                                 @RequestParam(required = false) String searchTitle,
                                 @RequestParam(required = false) String searchAuthor,
                                 Model model) {
        List<Article> articles = articleService.searchArticles(searchId, searchTitle, searchAuthor);
        model.addAttribute("articles", articles);
        model.addAttribute("searchId", searchId);
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchAuthor", searchAuthor);
        List<Comments> comments = commentsService.findAll();
        model.addAttribute("comments", comments);
        return "article/index";
    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/api/blog";
    }


    @GetMapping("/create")
    public String createArticle(Model model) {
        ArticleToCreate article = new ArticleToCreate();
        model.addAttribute("ArticleToCreate", article);
        return "article/create";
    }

    @PostMapping("/create")
    public String createArticle(@Valid @ModelAttribute("ArticleToCreate") ArticleToCreate article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ArticleToCreate", article);
            return "article/create";
        }

        Article newArticle = new Article();
        newArticle.setTitle(article.getTitle());
        newArticle.setContent(article.getContent());
        newArticle.setAuthor(article.getAuthor());
        articleService.createArticle(newArticle);
        return "redirect:/api/blog";
    }

    @GetMapping("/update")
    public String updateArticle(@RequestParam Long id, Model model) {
        Article article = articleService.getArticleById(id);

        ArticleToCreate newarticle = new ArticleToCreate();
        newarticle.setTitle(article.getTitle());
        newarticle.setContent(article.getContent());
        newarticle.setAuthor(article.getAuthor());
        model.addAttribute("ArticleToCreate", newarticle);
        model.addAttribute("Article", article);
        return "article/update";


    }

    @PostMapping("/update")
    public String UpdateArticle(@Valid @ModelAttribute("ArticleToCreate") ArticleToCreate article,
                                BindingResult result,
                                @RequestParam Long id,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("ArticleToCreate", article);
            return "article/update";
        }

        Article newArticle = articleService.getArticleById(id);
        model.addAttribute("article", newArticle);


        newArticle.setTitle(article.getTitle());
        newArticle.setContent(article.getContent());
        newArticle.setAuthor(article.getAuthor());
        articleService.updateArticle(newArticle);

        return "redirect:/api/blog";
    }




}
