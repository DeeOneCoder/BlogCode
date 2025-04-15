package com.davido.DavidoBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "blog_detail")
public class BlogDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blog_id;
    private String title;
    private String author;

    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Lob
    private String content;
    @ElementCollection
    private List<String> tags;
    private String imageUrl;
    private Date publishedDate;


    @OneToMany(mappedBy = "blog")
    private List<Comments> comments;

}
