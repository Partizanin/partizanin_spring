package hw11.model.dao.client;

import com.sun.xml.internal.ws.handler.HandlerException;
import hw11.model.domain.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 20.09.2014
 * Time:  10:30
 * To change this template use File|Setting|File Templates.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    private static Logger log = Logger.getLogger(ClientDaoImpl.class);
    private SessionFactory factory;

    @Autowired
    public ClientDaoImpl(SessionFactory factory) {

        this.factory = factory;

    }

    public ClientDaoImpl() {
    }


    @Override
    public void create(Client client) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (HandlerException e) {
            log.error("create message");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Client read(long id) {
        Session session = factory.openSession();

        try {
            return (Client) session.get(Client.class, id);
        } catch (HandlerException e) {
            log.error("read Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Client client) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        } catch (HandlerException e) {
            log.error("Update Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Client client) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (HandlerException e) {
            log.error("Delete method");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> findAll() {
        Session session = factory.openSession();

        try {
            return session.createCriteria(Client.class).list();
        } catch (HandlerException e) {
            log.error("Find all method");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
