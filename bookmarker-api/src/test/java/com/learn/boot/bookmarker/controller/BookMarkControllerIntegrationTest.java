package com.learn.boot.bookmarker.controller;

import com.learn.boot.bookmarker.entity.BookMarkerEntity;
import com.learn.boot.bookmarker.repositories.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.time.Instant;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine://demo"
})
@AutoConfigureTestDatabase
public class BookMarkControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private ConfigurableWebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAllInBatch();
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
    }

    @ParameterizedTest
    @CsvSource({
            "1,5,1,1",
            "2,5,1,2"
    })
    void verifyGetAll(int pageNumber, int totalElements, int totalPages, int currentPage) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/bookmarks?pageNumber"+pageNumber))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)));
                //.andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)));
    }

}
