package com.example.vaccinesideeffectswebsite.mapper;

import java.util.HashMap;

public interface AccountMapper {
    public HashMap findAccount(HashMap<String, Object> map);
    public void insertAccount(HashMap<String, Object> map);
}