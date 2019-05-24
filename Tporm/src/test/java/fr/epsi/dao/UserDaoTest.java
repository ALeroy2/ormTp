package fr.epsi.dao;

import fr.epsi.model.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Alexis");
        user.setLastname("Leroy");

        System.out.println(new UserDao().save(user));
    }

    @Test
    public void getUser() {
        User u = new UserDao().get(1l);
        System.out.println(u.getFirstname());
    }
}
