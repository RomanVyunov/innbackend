package com.example.demo;

import com.example.demo.data.UserData;
import com.example.demo.data.UserDataRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
public class UserRestController {

    UserDataRepository userRepo;

    @Autowired
    UserRestController(UserDataRepository userRepo){
        this.userRepo = userRepo;
        userRepo.save(new UserData("Виталий", "123456789011","123456781", "908-155-1231", "OOO Company1", "Руководитель 1"));
        userRepo.save(new UserData("Владимир", "123456789012","123456782", "908-155-1232", "OOO Company2", "Руководитель 2"));
        userRepo.save(new UserData("Виталий", "123456789013","123456783", "908-155-1233", "OOO Company3", "Руководитель 3"));
        userRepo.save(new UserData("Анатолий", "123456789014","123456784", "908-155-1234", "OOO Company4", "Руководитель 4"));
    }

    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable Long id){
        Optional<UserData> userData = userRepo.findById(id);
        String company = "Company";
        UserInfo info = null;
        if (userData.isPresent()) {
            info = new UserInfo(userData.get().getId(),
                    userData.get().getName(),
                    userData.get().getInn(),
                    userData.get().getKpp(),
                    userData.get().getPhone(),
                    userData.get().getCompany(),
                    userData.get().getManager());
        }
        return info;
    }


    @GetMapping("/users")
    public List<UserInfo> getUsers() {
        List<UserInfo> usersInfos = new ArrayList<>();
        List<UserData> users = (List) userRepo.findAll();
        usersInfos = users.stream()
                .map(data -> new UserInfo(data.getId(),
                        data.getName(),
                        data.getInn(),
                        data.getKpp(),
                        data.getPhone(),
                        data.getCompany(),
                        data.getManager()))
                .collect(Collectors.toList());
        return usersInfos;
    }

    @GetMapping("/usersfiltered")
    public List<UserInfo> getUsersFiltered(@RequestParam String name){

        List<UserInfo> usersInfos = new ArrayList<>();
        List<UserData> users = userRepo.findByNameStartingWith(name);
        usersInfos = users.stream()
                .map(data -> new UserInfo(data.getId(),
                        data.getName(),
                        data.getInn(),
                        data.getKpp(),
                        data.getPhone(),
                        data.getCompany(),
                        data.getManager()))
                .collect(Collectors.toList());
        return usersInfos;
    }


    @PostMapping("/adduser")
    public ResponseEntity<String> createUser(@RequestBody UserInfo info){

        if(userRepo.findByInnAndKpp(info.getInn(), info.getKpp()) != null){
            return new ResponseEntity<>("User was not created. KPP and INN must be unique", HttpStatus.BAD_REQUEST);
        }

        UserData tmp = userRepo.save(new UserData(info.getName(),
                                                    info.getInn(),
                                                    info.getKpp(),
                                                    info.getPhone(),
                                                    info.getCompany(),
                                                    info.getManager()));
        return new ResponseEntity<>("User "+tmp.getName()+" was created.", HttpStatus.OK);
    }

}
