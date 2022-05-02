package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Article")
public class Article implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "title", length = 50, nullable = false, unique = true)
    private String title;

    @Column(name = "`status`", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
