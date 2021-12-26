package com.example.vaccinesideeffectswebsite.service;

import java.util.HashMap;

public interface AccountService {
    public HashMap findAccount(HashMap<String, Object> map);
    public void insertAccount(HashMap<String, Object> map);
}