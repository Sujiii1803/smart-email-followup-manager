package com.suji.followup.controller;

import com.suji.followup.gmail.InboxCheckScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gmail")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class GmailController {

    private final InboxCheckScheduler scheduler;

    @PostMapping("/sync")
    public String syncInbox() {
        scheduler.mockInboxScan();
        return "Inbox synced successfully";
    }
}
