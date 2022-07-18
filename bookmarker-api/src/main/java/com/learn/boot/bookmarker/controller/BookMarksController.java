package com.learn.boot.bookmarker.controller;

import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
@Validated
public class BookMarksController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookMarkDto getAllBookmarks(@RequestParam(required = false,defaultValue = "0") Integer pageNumber) {
        return bookmarkService.getAll(pageNumber);
    }
}
