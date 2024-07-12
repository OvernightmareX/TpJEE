package com.example.exo5.repositories;

import com.example.exo5.utils.SessionFactorySingleton;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;


public abstract class BaseRepository<T> {
    protected SessionFactory sessionFactory;
    protected Session session;

    public BaseRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public boolean save (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(element);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean delete (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(element);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public T findById (Class<T> classe, int id){
        session = sessionFactory.openSession();
        T element = session.get(classe,id);
        session.close();
        return element;
    }

    public T findById (Class<T> classe, UUID id){
        session = sessionFactory.openSession();
        T element = session.get(classe,id);
        session.close();
        return element;
    }

    public List<T> findAll(Class<T> classe){
        String query = "FROM " + classe.getSimpleName();
        session = sessionFactory.openSession();
        Query typedQuery = session.createQuery(query, classe);
        List<T> list = typedQuery.getResultList();
        session.close();
        return list;
    }

    public long count(Class<T> classe){
        String query = "SELECT COUNT(c) FROM " + classe.getSimpleName() +" c";
        session = sessionFactory.openSession();
        Query typedQuery = session.createQuery(query, Long.class);
        long count = (long) typedQuery.getSingleResult();
        session.close();
        return count;
    }
}