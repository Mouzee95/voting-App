package com.mouzeeCode.voting_App.service;

import com.mouzeeCode.voting_App.model.Poll;
import com.mouzeeCode.voting_App.repository.PollRepository;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }
}
