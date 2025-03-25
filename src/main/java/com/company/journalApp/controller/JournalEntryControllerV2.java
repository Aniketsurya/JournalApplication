package com.company.journalApp.controller;

import com.company.journalApp.entity.JournalEntry;
import com.company.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    // Always controller class will be having public access as it should be accessed by spring
    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping()
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return myEntry;
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
