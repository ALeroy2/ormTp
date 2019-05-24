package fr.epsi.dao;


import fr.epsi.model.Admin;

import java.util.List;


public class AdminDao extends AbstractDao<Admin> {

    public List getAll(){
        return this.execute(s -> s.createQuery("from admin").list());
    }

}
