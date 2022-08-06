package com.learn.boot.bookmarker.controller;

import com.learn.boot.bookmarker.domain.BookMarkCreateRequest;
import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.domain.BookMarks;
import com.learn.boot.bookmarker.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
@Validated
public class BookMarksController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookMarkDto getAllBookmarks(@RequestParam(required = false, defaultValue = "0") Integer pageNumber) {
        return bookmarkService.getAll(pageNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookMarks createBookMark(@RequestBody @Valid BookMarkCreateRequest bookMarkCreateRequest) {
        return bookmarkService.createBookmark(bookMarkCreateRequest);
    }
}
