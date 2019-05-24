package fr.epsi.dao;

import fr.epsi.model.Conversation;
import fr.epsi.model.Message;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConversationDao extends AbstractDao<Conversation> {
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
}
