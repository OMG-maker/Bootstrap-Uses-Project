package com.example.vaccinesideeffectswebsite.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AccountMapperImpl
        implements AccountMapper {

    @Autowired
    private AccountMapper accountMapper;

    public HashMap findAccount(HashMap<String, Object> map) {
        return this.accountMapper.findAccount(map);
    }

    public String findPassword(String password){
        return this.accountMapper.findPassword(password);
    }

    public void insertAccount(HashMap<String, Object> map){
        this.accountMapper.insertAccount(map);
    }
}