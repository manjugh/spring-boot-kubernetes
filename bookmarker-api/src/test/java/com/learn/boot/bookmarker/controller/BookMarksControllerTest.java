package com.learn.boot.bookmarker.controller;

import com.learn.boot.bookmarker.domain.BookMarkDto;
import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import com.learn.boot.bookmarker.service.BookmarkService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@WebMvcTest
class BookMarksControllerTest {

    @MockBean
    private BookmarkService bookmarkService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void verifyGetAll() throws Exception {
        BDDMockito.given(bookmarkService.getAll(10)).willReturn(new BookMarkDto(new PageStub()));
        mockMvc.perform(MockMvcRequestBuilders.get("/bookmarks"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    class PageStub implements Page<BookMarkerEntity> {

        @Override
        public int getTotalPages() {
            return 0;
        }

        @Override
        public long getTotalElements() {
            return 0;
        }

        @Override
        public int getNumber() {
            return 0;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public int getNumberOfElements() {
            return 0;
        }

        @Override
        public List<BookMarkerEntity> getContent() {
            return null;
        }

        @Override
        public boolean hasContent() {
            return false;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Pageable nextPageable() {
            return null;
        }

        @Override
        public Pageable previousPageable() {
            return null;
        }

        @Override
        public <U> Page<U> map(final Function<? super BookMarkerEntity, ? extends U> converter) {
            return null;
        }

        @NotNull
        @Override
        public Iterator<BookMarkerEntity> iterator() {
            return null;
        }
    }
}