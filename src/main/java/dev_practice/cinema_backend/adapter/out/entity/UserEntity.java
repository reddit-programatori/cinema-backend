package dev_practice.cinema_backend.adapter.out.entity;


import jakarta.persistence.*;

import java.util.List;

/**
 * Database representation of a user.
 * Mapped to the users table.
 * Has one-to-many relations to comment.
 */

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "userEntity")
    List<CommentEntity> commentEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, String password, List<CommentEntity> commentEntities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.commentEntities = commentEntities;
    }
}
