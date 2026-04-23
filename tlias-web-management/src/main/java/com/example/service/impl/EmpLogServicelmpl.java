package com.example.service.impl;

import com.example.mapper.EmpLogMapper;
import com.example.pojo.EmpLog;
import com.example.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLogServicelmpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Override
    public void insert(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

}
