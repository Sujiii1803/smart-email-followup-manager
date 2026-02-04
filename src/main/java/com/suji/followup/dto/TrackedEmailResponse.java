package com.suji.followup.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackedEmailResponse {

    private Long id;
    private String fromEmail;
    private String subject;
    private boolean replied;
    private LocalDateTime receivedAt;

}
