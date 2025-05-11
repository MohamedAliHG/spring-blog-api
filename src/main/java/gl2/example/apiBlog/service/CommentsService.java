package gl2.example.apiBlog.service;

import gl2.example.apiBlog.model.Comments;
import gl2.example.apiBlog.repository.ArticleRepository;
import gl2.example.apiBlog.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }



}
