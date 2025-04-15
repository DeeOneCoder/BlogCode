package com.davido.DavidoBlog.service;

import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Comments;
import com.davido.DavidoBlog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comments findById(Long id){
        return commentRepository.findById(id).isPresent() ? commentRepository.findById(id).get() : null;
    }

    public Comments findByUser(String user){
        return commentRepository.findByUser(user).isPresent() ? commentRepository.findByUser(user).get() : null;
    }

    List<Comments> findByBlog(BlogDetail blog){
        return commentRepository.findByBlog(blog).isPresent() ? commentRepository.findByBlog(blog).get() : null;
    }
}
