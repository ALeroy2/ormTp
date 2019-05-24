package fr.epsi.dao;

import fr.epsi.model.Admin;
import fr.epsi.model.CreditCard;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CreditCardDaoTest{

    @Test
    public void insertCreditCard(){
        Admin admin = new Admin();
        admin.setFirstname("Alexis");
        admin.setLastname("Leroy");
        admin.setEmail("alexis.leroy1@epsi.fr");
        admin.setBirthday(new Date());

        admin.setCreditCardCode("111");
        admin.setCreditCardDate(new Date());
        admin.getCreditCardNumber("1234567891234567");

    }

}