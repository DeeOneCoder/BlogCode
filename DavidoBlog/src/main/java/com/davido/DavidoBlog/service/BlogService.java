package com.davido.DavidoBlog.service;

import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Category;
import com.davido.DavidoBlog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogDetail postBlog(BlogDetail blog){
        return blogRepository.save(blog);
    }
    public BlogDetail getBlogById(Long id){
        return blogRepository.findById(id).isPresent() ? blogRepository.findById(id).get() : null;
    }

    public BlogDetail getBlogByTitle(String title){
        return blogRepository.findByTitle(title).isPresent() ? blogRepository.findByTitle(title).get() : null;
    }

    public List<BlogDetail> findByCategory(Category category){
        return blogRepository.findByCategory(category).isPresent() ? blogRepository.findByCategory(category).get() : null;
    }
    public List<BlogDetail> findByTags(List<String> tags){
        return blogRepository.findByTags(tags).isPresent() ? blogRepository.findByTags(tags).get() : null;
    }
    public List<BlogDetail> findByPublishedDate(Date date){
        return blogRepository.findByPublishedDate(date).isPresent() ? blogRepository.findByPublishedDate(date).get() : null;
    }

    public BlogDetail updateBlog(BlogDetail blog, Long id){
        BlogDetail toUpdate = getBlogById(id);
        assert toUpdate != null;
        toUpdate.setCategory(blog.getCategory());
        toUpdate.setContent(blog.getContent());
        return blogRepository.save(toUpdate);
    }

    public BlogDetail deleteBlog(Long id){
        BlogDetail toDelete = getBlogById(id);
        blogRepository.deleteById(id);
        return toDelete;
    }

}
