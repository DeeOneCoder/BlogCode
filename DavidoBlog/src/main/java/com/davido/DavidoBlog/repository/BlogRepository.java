package com.davido.DavidoBlog.repository;

import com.davido.DavidoBlog.model.BlogDetail;
import com.davido.DavidoBlog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository(value = "BlogRepository")
public interface BlogRepository extends JpaRepository<BlogDetail, Long> {
    Optional<List<BlogDetail>> findByCategory(Category category);
    Optional<List<BlogDetail>> findByTags(List<String> tags);
    Optional<List<BlogDetail>> findByPublishedDate(Date date);


    Optional<BlogDetail> findByTitle(String title);
}
