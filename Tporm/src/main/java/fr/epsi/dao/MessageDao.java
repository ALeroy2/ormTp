package fr.epsi.dao;

import fr.epsi.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.query.Query;

public class MessageDao extends AbstractDao<Message> {

    public List<Message> getArobase(List<String> arobase){
        if(arobase.size()>0){
            return this.execute(session -> {
                Query query = session.createQuery("from Message where text like :arobase");
                query.setParameterList("arobase", arobase.stream().map(a->"%@" + a + "%").collect(Collectors.toList()));

                return ((org.hibernate.query.Query) query).list();
            });
        }
        return new ArrayList<>();
    }

    public List<Message> getByUser(long userId){
        return this.execute(s-> s.createQuery("from Message where user.id="+userId).list());
    }
}

