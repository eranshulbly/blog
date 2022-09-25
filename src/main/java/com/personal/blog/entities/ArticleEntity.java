package com.personal.blog.entities;

import javax.persistence.*;
import lombok.*;

@Entity(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity extends BaseEntity{
    private String heading;
    private String subHeading;
    private String content;
    private String slug;
    private int authorId;
}
