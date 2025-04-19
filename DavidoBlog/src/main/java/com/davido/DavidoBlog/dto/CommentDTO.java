package com.davido.DavidoBlog.dto;

import com.davido.DavidoBlog.model.BlogDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CommentDTO {

    private String user;

    @Lob
    @NotBlank(message = "Comment can not be blank")
    @Length(min = 3, max = 500)
    private String comment;

}
