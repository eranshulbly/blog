package com.personal.blog.entities;

import lombok.*;

import javax.persistence.Entity;

@Entity(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentEntity extends BaseEntity{
    private String title;
    private String body;
    private int articleId;
    private int authorId;
}
