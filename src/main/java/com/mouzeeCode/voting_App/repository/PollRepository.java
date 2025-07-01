package com.mouzeeCode.voting_App.repository;

import com.mouzeeCode.voting_App.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
