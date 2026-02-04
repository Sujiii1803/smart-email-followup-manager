package com.suji.followup.controller;

import com.suji.followup.dto.EmailStatsResponse;
import com.suji.followup.dto.TrackedEmailResponse;
import com.suji.followup.entity.TrackedEmail;
import com.suji.followup.repository.TrackedEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final TrackedEmailRepository repository;

    @GetMapping("/pending")
    public List<TrackedEmailResponse> pendingEmails() {
        return repository.findByRepliedFalse()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @GetMapping("/stats")
    public EmailStatsResponse stats() {
        return EmailStatsResponse.builder()
                .totalEmails(repository.count())
                .pendingReplies(repository.countByRepliedFalse())
                .repliedEmails(repository.countByRepliedTrue())
                .build();
    }

    private TrackedEmailResponse toDto(TrackedEmail e) {
        return TrackedEmailResponse.builder()
                .id(e.getId())
                .fromEmail(e.getFromEmail())
                .subject(e.getSubject())
                .replied(e.isReplied())
                .receivedAt(e.getReceivedAt())
                .build();
    }

    @PutMapping("/{id}/replied")
    public void markAsReplied(@PathVariable Long id) {
        TrackedEmail email = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Email not found"));
        email.setReplied(true);
        repository.save(email);
    }

}
