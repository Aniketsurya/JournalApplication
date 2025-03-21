package com.company.journalApp.controller;

import com.company.journalApp.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    // Always controller class will be having public access as it should be accessed by spring
    @GetMapping
    public List<JournalEntry> getAll(){

        return null;
    }

    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
        return null;
    }
}
