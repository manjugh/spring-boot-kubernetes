package com.learn.boot.bookmarker.repositories;

import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<BookMarkerEntity, Long> {


}
