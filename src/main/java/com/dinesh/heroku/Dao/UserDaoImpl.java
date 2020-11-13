package com.dinesh.heroku.Dao;

import com.dinesh.heroku.Model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save_user(User user) {

        Session session=entityManager.unwrap(Session.class);

//        user.setId(0);

        session.saveOrUpdate(user);



    }

    @Override
    @Transactional
    public List<User> getusers() {

        Session session=entityManager.unwrap(Session.class);

        Query<User> query=  session.createQuery("from User",User.class);

        List<User> users=query.getResultList();

        return users;


    }

    @Override
    @Transactional
    public boolean getuserlogin(String name,String pass) {

        Session session=entityManager.unwrap(Session.class);

        TypedQuery<User> user =session.createQuery("from User where name=:n AND pass=:p",User.class);

        user.setParameter("n",name);
        user.setParameter("p",pass);

        if(user!=null){
            return true;
        }

        return false;
    }


}
