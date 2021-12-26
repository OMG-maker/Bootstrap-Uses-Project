package com.example.vaccinesideeffectswebsite.service;

import com.example.vaccinesideeffectswebsite.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AccountServiceImpl
        implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public HashMap findAccount(HashMap<String, Object> map) {
        return this.accountMapper.findAccount(map);
    }

    public void insertAccount(HashMap<String, Object> map){
        this.accountMapper.insertAccount(map);
    }
}