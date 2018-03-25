package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addUser(User user) {

        if (!isUserAlreadyExisting(user)) {
            entityManager.flush();
            entityManager.merge(user);
        }
    }

    public boolean isUserAlreadyExisting(User user) {

        String userEmail = user.getEmail();

        Query query = entityManager
                .createQuery("select u from User u where u.email =:email")
                .setParameter("email",userEmail);

        return !query.getResultList().isEmpty();
    }
}
