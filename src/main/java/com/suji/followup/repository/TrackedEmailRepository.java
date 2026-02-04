package com.suji.followup.repository;

import com.suji.followup.entity.TrackedEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackedEmailRepository extends JpaRepository<TrackedEmail, Long> {

    List<TrackedEmail> findByRepliedFalse();

    long countByRepliedFalse();

    long countByRepliedTrue();

    boolean existsByGmailThreadId(String gmailThreadId);

}
