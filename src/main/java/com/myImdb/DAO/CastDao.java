package com.myImdb.DAO;

import com.myImdb.model.Cast;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by trauma_sushan on 8/7/2017.
 */
@Repository
@Transactional

public class CastDao {
    private SessionFactory sessionFactory;

    @Autowired
    public CastDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(Cast cast){
        try{
            Session session = sessionFactory.getCurrentSession();
            session.save(cast);
        }
        catch (HibernateException exception){
            System.out.println("error: " + exception.getMessage());
            exception.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public List<Cast> getAll(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cast");
        return query.list();
    }

    public Cast get(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from Cast c where c.id = "+id);
        Cast cast = (Cast) query.uniqueResult();
        return cast;
    }

    public void update(int id, Cast cast){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Cast c set c.name = : name where c.id = :castid");
        query.setParameter("castid", id);
        query.setParameter("name", cast.getName());
        query.executeUpdate();
    }

    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Cast c where c.id = :castid");
        query.setParameter("castid", id);
        query.executeUpdate();
    }
}
