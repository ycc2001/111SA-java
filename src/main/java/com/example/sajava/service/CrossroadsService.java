package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.CrossroadsModel;
import com.example.sajava.repository.CrossroadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CrossroadsService {
    @Autowired
    CrossroadsRepository crossroadsRepository;

    public Data add(CrossroadsModel crossroadsModel){
        return crossroadsRepository.insertCrossroads(crossroadsModel);
    }

    public Data del(CrossroadsModel crossroadsModel){
        return crossroadsRepository.delCrossroads(crossroadsModel);
    }

    public Data search(Map<String, Object> reqBody){
        return crossroadsRepository.selectCrossroads(reqBody);
    }

    public Data all(){
        return crossroadsRepository.selectAllCrossroads();
    }

}
