package com.suji.followup.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailStatsResponse {

    private long totalEmails;
    private long pendingReplies;
    private long repliedEmails;
}
