package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2)
    private String name;
    @Past
    private Date birhtdata;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

}
