package com.learn.boot.bookmarker.repositories;

import com.learn.boot.bookmarker.domain.BookMarks;
import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<BookMarkerEntity, Long> {

    @Query("select new com.learn.boot.bookmarker.domain.BookMarks(bme.id,bme.title,bme.url,bme.createdAt) from BookMarkerEntity bme")
    public Page<BookMarks> findBookMarks(Pageable pageable);


}
