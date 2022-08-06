package com.learn.boot.bookmarker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkerEntity {

    @Id
    @SequenceGenerator(sequenceName = "bookmark_id_seq", name = "bookmark_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="bookmark_id_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;


    @Column(name = "created_at")
    private Instant createdAt;
}
