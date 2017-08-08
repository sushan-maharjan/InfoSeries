package com.myImdb.DAO;

import com.myImdb.model.Cast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by trauma_sushan on 8/7/2017.
 */
@Repository
public interface UserDao extends CrudRepository<Cast,Integer> {

    public Cast findById(String id);

}
