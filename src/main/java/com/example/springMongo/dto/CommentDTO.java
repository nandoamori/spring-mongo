package com.example.springMongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private String text;
    private Date date;
    private AuthorDTO author;
}
