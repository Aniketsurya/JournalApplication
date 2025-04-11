package com.company.journalApp.service;

import com.company.journalApp.entity.JournalEntry;
import com.company.journalApp.entity.User;
import com.company.journalApp.repository.JournalEntryRepository;
import com.company.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveEntry(User user){
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteByID(ObjectId myId){
        userRepository.deleteById(myId);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
