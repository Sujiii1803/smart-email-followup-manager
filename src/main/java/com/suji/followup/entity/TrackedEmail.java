package com.suji.followup.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tracked_emails")
public class TrackedEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromEmail;

    private String subject;

    private boolean replied;

    private LocalDateTime receivedAt;

    private String gmailThreadId;
}
