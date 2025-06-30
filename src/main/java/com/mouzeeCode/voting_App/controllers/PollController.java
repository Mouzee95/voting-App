package com.mouzeeCode.voting_App.controllers;

import com.mouzeeCode.voting_App.model.Poll;
import com.mouzeeCode.voting_App.service.PollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private PollService pollService;

    public PollController(PollService pollService){
        this.pollService=pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }
}
