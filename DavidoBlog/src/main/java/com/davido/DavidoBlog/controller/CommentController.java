package com.davido.DavidoBlog.controller;

import com.davido.DavidoBlog.dto.CommentDTO;
import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Comments;
import com.davido.DavidoBlog.service.BlogService;
import com.davido.DavidoBlog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Comments findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("title/")
    public Comments findByUser(@RequestParam String user){
        return commentService.findByUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("blog/")
    public List<Comments> findByBlog(@RequestParam BlogDetail blog){
        return commentService.findByBlog(blog);
    }


//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/{blog_id}")
//    public Comments postComment(@Valid @RequestBody CommentDTO commentDTO, @PathVariable Long blog_id){
//        BlogDetail blog = blogService.getBlogById(blog_id);
//        Comments comments = new Comments();
//        comments.setComment(commentDTO.getComment());
//        comments.setUser(commentDTO.getUser());
//        comments.setBlog(blog);
//        return commentService.postComment(comments);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Comments> getAllComments(){
        return commentService.getAllComments();
    }
}
