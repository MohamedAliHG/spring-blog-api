package gl2.example.apiBlog.model;

import jakarta.validation.constraints.*;

public class ArticleToCreate {

    @NotEmpty(message = "author is required")
    private String author;

    @NotEmpty(message= "title is required")
    private String title;

    @NotEmpty(message= "content is required")
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
