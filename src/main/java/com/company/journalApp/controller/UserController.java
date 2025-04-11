package com.company.journalApp.controller;

import com.company.journalApp.entity.JournalEntry;
import com.company.journalApp.entity.User;
import com.company.journalApp.service.JournalEntryService;
import com.company.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private UserService userService;

   @GetMapping
    public List<User> getAllUsers(){
       return userService.getAll();
   }

   @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
       User userSaved = userService.saveEntry(user);
       return new ResponseEntity<>(userSaved,HttpStatus.CREATED);
   }

   @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String username){
        User userInDb = userService.findByUsername(username);
        if(userInDb!=null){
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
