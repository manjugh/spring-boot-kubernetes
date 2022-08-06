package com.learn.boot.bookmarker.service;

import com.learn.boot.bookmarker.domain.BookMarkCreateRequest;
import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.domain.BookMarks;
import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import com.learn.boot.bookmarker.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkService {

    public final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public BookMarkDto getAll(Integer pageNumber) {
        pageNumber = pageNumber < 1 ? 0 : pageNumber - 1;
        PageRequest pageRequest = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");
        return new BookMarkDto(bookmarkRepository.findBookMarks(pageRequest));
    }

    public BookMarks createBookmark(final BookMarkCreateRequest bookMarkCreateRequest) {
        BookMarkerEntity bookMarkerEntity = new BookMarkerEntity(null,bookMarkCreateRequest.getTitle(),bookMarkCreateRequest.getUrl(), Instant.now());
        BookMarkerEntity save = bookmarkRepository.save(bookMarkerEntity);
        BookMarks bookMarkDto = new BookMarks();
        bookMarkDto.setId(save.getId());
        bookMarkDto.setTitle(save.getTitle());
        bookMarkDto.setUrl(save.getUrl());
        bookMarkDto.setCreatedAt(save.getCreatedAt());
        return bookMarkDto;
    }
}
