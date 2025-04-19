package com.davido.DavidoBlog.controller;

import com.davido.DavidoBlog.dto.BlogDTO;
import com.davido.DavidoBlog.dto.CommentDTO;
import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Category;
import com.davido.DavidoBlog.model.Comments;
import com.davido.DavidoBlog.service.BlogService;
import com.davido.DavidoBlog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public BlogDetail postBlog(@RequestBody BlogDTO blog){
        BlogDetail detail = new BlogDetail();
        detail.setAuthor(blog.getAuthor());
        detail.setCategory(blog.getCategory());
        detail.setContent(blog.getContent());
        detail.setTitle(blog.getTitle());
        detail.setTags(blog.getTags());
        detail.setImageUrl(blog.getImageUrl());
        return blogService.postBlog(detail);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<BlogDetail> allBlogs(){
        List<BlogDetail> details = blogService.allBlogs();
        for( BlogDetail blog: details ){
            List<Comments> comments = commentService.findByBlog(blog);
            blog.setComments(comments);
        }
        return details;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("id/{id}")
    public BlogDetail getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("title/")
    public BlogDetail getBlogByTitle(@RequestParam String title){
        return blogService.getBlogByTitle(title);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("category/")
    public List<BlogDetail> findByCategory(@RequestParam Category category){
        return blogService.findByCategory(category);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("tags/")
    public List<BlogDetail> findByTags(@RequestBody List<String> tags){
        return blogService.findByTags(tags);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("date/")
    public List<BlogDetail> findByPublishedDate(@RequestBody Date date){
        return blogService.findByPublishedDate(date);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("update/{id}")
    public BlogDetail updateBlog(@RequestBody BlogDetail blog, @PathVariable Long id){
        return blogService.updateBlog(blog, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("delete/{id}")
    public BlogDetail deleteBlog(Long id){
        BlogDetail toDelete = getBlogById(id);
        blogService.deleteBlog(id);
        return toDelete;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{blog_id}")
    public BlogDetail postComment(@Valid @RequestBody CommentDTO commentDTO, @PathVariable Long blog_id) {
        BlogDetail blog = blogService.getBlogById(blog_id);
        Comments comments = new Comments();
        comments.setComment(commentDTO.getComment());
        if( commentDTO.getUser() != null && commentDTO.getUser().length() > 2){
            comments.setUser(commentDTO.getUser());
        }else {
            comments.setUser("Anonymous");
        }

        comments.setBlog(blog);
        commentService.postComment(comments);
        return blogService.postBlog(blog);
    }

}
