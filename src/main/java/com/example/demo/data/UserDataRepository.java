package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDataRepository extends CrudRepository<UserData, Long> {

    List<UserData> findByNameStartingWith(String name);

    UserData findByInnAndKpp(String inn, String kpp);
}
