package com.suji.followup.scheduler;

import com.suji.followup.repository.TrackedEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReplyReminderScheduler {

    private final TrackedEmailRepository repository;

    @Scheduled(fixedRate = 120000)
    public void checkPendingReplies() {

        repository.findByRepliedFalse().forEach(email ->
                System.out.println("⏰ Reminder: Reply pending for " + email.getFromEmail())
        );
    }
}
