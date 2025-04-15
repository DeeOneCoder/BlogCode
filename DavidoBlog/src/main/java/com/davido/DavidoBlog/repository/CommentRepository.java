package com.davido.DavidoBlog.repository;

import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository(value = "CommentRepository")
public interface CommentRepository extends JpaRepository<Comments, Long> {
    Optional<Comments> findByUser(String user);
    Optional<List<Comments>> findByBlog(BlogDetail blog);
}
