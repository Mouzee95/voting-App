package com.mouzeeCode.voting_App.service;

import com.mouzeeCode.voting_App.model.OptionVote;
import com.mouzeeCode.voting_App.model.Poll;
import com.mouzeeCode.voting_App.repository.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return  pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        //Get poll from Database
        Poll poll= pollRepository.findById(pollId)
                .orElseThrow(()-> new RuntimeException("Poll not found"));

        //Get all options
        List< OptionVote > options= poll.getOptions();

        //if index for vote is not valid, throw an error
        if (optionIndex < 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }

        //Get selected user options

        OptionVote selectedOption = options.get(optionIndex);

        //Increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        //Save incremented vote option into the database
        pollRepository.save(poll);
    }


}
