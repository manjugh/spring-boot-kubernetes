package com.learn.boot.bookmarker.domain;

import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookMarkDto {

    private List<BookMarks> data;

    private long totalElements;

    private int totalPages;

    private int currentPage;

    private boolean first;

    private boolean last;

    private boolean hasNext;

    private boolean hasPrevious;

    public BookMarkDto(Page<BookMarks> page) {
        this.data = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber()+1;
        this.first = page.isFirst();
        this.last = page.isLast();
        this.hasNext = page.hasNext();
        this.hasPrevious = page.hasPrevious();
    }
}
