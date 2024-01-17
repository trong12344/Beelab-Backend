package com.Beelab.Entity;

import com.Beelab.Common.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int product_id;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int rated_start;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int status;
    
    
    @ManyToOne
	@JoinColumn(name = "user_id")
	User user;

    
}

