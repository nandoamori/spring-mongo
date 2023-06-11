package com.example.springMongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private  String name;
    private String email;

}
