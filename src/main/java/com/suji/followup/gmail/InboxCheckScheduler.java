package com.suji.followup.gmail;

import com.suji.followup.entity.TrackedEmail;
import com.suji.followup.repository.TrackedEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InboxCheckScheduler {

    private final TrackedEmailRepository repository;

    @Scheduled(fixedRate = 6000)
    public void mockInboxScan() {

        if (repository.existsByGmailThreadId("mock-thread")) {
            return;
        }

        TrackedEmail email = TrackedEmail.builder()
                .fromEmail("hr@company.com")
                .subject("Interview Update")
                .receivedAt(LocalDateTime.now())
                .replied(false)
                .gmailThreadId("mock-thread")
                .build();

        repository.save(email);
    }

}
