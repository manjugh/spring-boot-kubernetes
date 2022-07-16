package com.learn.boot.bookmarker.controller;

import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
public class BookMarksController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookMarkDto getAllBookmarks(@NotNull @RequestParam(defaultValue = "0", required = false) Integer pageNumber) {
        return bookmarkService.getAll(pageNumber);
    }
}
