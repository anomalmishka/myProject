package org.example.service.webClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.models.UserProfileDTO;
import org.example.model.database.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Service
@AllArgsConstructor
public class UserProfileService {
    private static final String USERS_URL_TEMPLATE = "/user/profile/read/2/";
    private static final String BROKEN_URL_TEMPLATE = "/broken-url/{id}";
    public static final int DELAY_MILLIS = 100;
    public static final int MAX_RETRY_ATTEMPTS = 3;
    private final WebClient webClient;

    public Mono<UserProfileDTO> getUserByIdAsync(final String id) {
        return webClient
                .get()
                .uri(USERS_URL_TEMPLATE, id)
                .retrieve()
                .bodyToMono(UserProfileDTO.class);
    }

    public UserProfileDTO getUserByIdSync(final String id) {
        return webClient
                .get()
                .uri(USERS_URL_TEMPLATE, id)
                .retrieve()
                .bodyToMono(UserProfileDTO.class)
                .block();
    }

    public UserProfile getUserWithRetry(final String id) {
        return webClient
                .get()
                .uri(BROKEN_URL_TEMPLATE, id)
                .retrieve()
                .bodyToMono(UserProfile.class)
                .retryWhen(Retry.fixedDelay(MAX_RETRY_ATTEMPTS, Duration.ofMillis(DELAY_MILLIS)))
                .block();
    }

    public UserProfile getUserWithFallback(final String id) {
        return webClient
                .get()
                .uri(BROKEN_URL_TEMPLATE, id)
                .retrieve()
                .bodyToMono(UserProfile.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new UserProfile()))
                .block();
    }

    public UserProfile getUserWithErrorHandling(final String id) {
        return webClient
                .get()
                .uri(BROKEN_URL_TEMPLATE, id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(UserProfile.class)
                .block();
    }
}

