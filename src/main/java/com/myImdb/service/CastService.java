package com.myImdb.service;

import com.myImdb.DAO.CastDao;
import com.myImdb.model.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trauma_sushan on 8/7/2017.
 */
@Service
public class CastService {
    private CastDao castDao;

    @Autowired
    public CastService(CastDao castDao){
        this.castDao = castDao;
    }

    public void createCast(Cast cast){
        castDao.add(cast);
    }

    public List<Cast> getAllCast(){
       // return castDao.getAll();
        return null;
    }
}
