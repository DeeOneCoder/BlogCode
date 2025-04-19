package com.davido.DavidoBlog.dto;

import com.davido.DavidoBlog.model.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data

public class BlogDTO {


    private String title;
    private String author;

    private Category category;
    @Lob
    private String content;
    @ElementCollection
    private List<String> tags;
    private String imageUrl;
    private Date publishedDate;

}
