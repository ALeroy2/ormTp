package fr.epsi.dao;

import fr.epsi.model.Conversation;
import fr.epsi.model.Message;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ConversationDaoTest {

    @Test
    public void insertMessageUser(){
        User user = new User();
        user.setFirstname("Alexis");
        user.setLastname("Leroy");
        user.setEmail("alexis.leroy1@epsi.fr");
        user.setBirthday(new Date());

        Message m1 = new Message();
        m1.setText("test 1");
        Message m2 = new Message();
        m2.setText("test 2");
        Message m3 = new Message();
        m3.setText("test 2");

        Conversation conversation = new Conversation();

        List<Message> messages = Arrays.asList(m1,m2,m3);
        messages.forEach(message -> message.setConversation(conversation));

        user.setMessages(messages);
        long userId = new UserDao().save(user);
        User newUser = new UserDao().get(userId);
        Assert.assertEquals(messages.size(), newUser.getMessages().size());
    }

    @Test
    public void getArobase() {
        Message m1 = new Message();
        m1.setText("test 1");
        Message m2 = new Message();
        m2.setText("test 2");
        Message m3 = new Message();
        m3.setText("test 2");
        Message m4 = new Message();
        m4.setText("c'est un @Test");

        Arrays.asList(m1,m2,m3,m4).forEach(message -> new MessageDao().save(message));
        Assert.assertEquals(2, new MessageDao().getArobase(Arrays.asList("Test")).size());

    }

}