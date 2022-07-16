package com.learn.boot.bookmarker;

import com.learn.boot.bookmarker.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(final String... args) throws Exception {
        /*bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepository.save(new BookMarkerEntity(null, "sivaLabs", "https://sivalabs.in", Instant.now()));*/
        log.info("Initializing data");
    }
}
