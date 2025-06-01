package com.company.journalApp.service;

import com.company.journalApp.entity.JournalEntry;
import com.company.journalApp.entity.User;
import com.company.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    //mongodb needs replication db for running Transactional, so we can use Mongodb Atlas to get it managed
    @Transactional // if journal entry got save but in User journalentry didn't got save then it should rollback journalentry from JournalEntry too
    public void saveEntry(JournalEntry journalEntry, String username){
        try{
        User user = userService.findByUsername(username);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);}
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occoured while saving journal entry ",e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteByID(ObjectId myId, String username){
        User user = userService.findByUsername(username);
        //delete from user's Journal entry which specific journal entry is to be deleted using myId
        user.getJournalEntries().removeIf(x -> x.getId().equals(myId));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(myId);
    }
}
