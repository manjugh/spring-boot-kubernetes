package com.learn.boot.bookmarker.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@RequiredArgsConstructor
public class BookMarkCreateRequest {

    @NotEmpty
    private final String title;

    @NotEmpty
    private final String url;
}
