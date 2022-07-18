package com.learn.boot.bookmarker.service;

import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
