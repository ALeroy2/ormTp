package fr.epsi.dao;

import fr.epsi.model.Admin;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class AdminDaoTest {

    @Test
    public void insertAdmin() {
        Admin admin = new Admin();
        admin.setFirstname("Alexis");
        admin.setLastname("Leroy");
        admin.setEmail("alexis.leroy1@epsi.fr");
        admin.setBirthday(new Date());

        Long userId = new AdminDao().save(admin);

        LinkedList<User> allAdmins = new LinkedList<>(new AdminDao().getAll());

        Assert.assertEquals(java.util.Optional.of(userId), allAdmins.getLast().getId());
    }
}