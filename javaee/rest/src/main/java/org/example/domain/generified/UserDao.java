package org.example.domain.generified;

import org.example.domain.User;
import org.example.util.PasswordUtils;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class UserDao extends Dao<User> {

    public void authenticate(String login, String password) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_LOGIN_PASSWORD, User.class);
        query.setParameter("login", login);
        query.setParameter("password", PasswordUtils.digestPassword(password));
        User user = query.getSingleResult();

        if (user == null) throw new SecurityException("Invalid user/password");
    }

}
