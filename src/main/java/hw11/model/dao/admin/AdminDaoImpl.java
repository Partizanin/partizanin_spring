package hw11.model.dao.admin;

import hw11.model.domain.Administrator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 14.09.2014
 * Time:  13:08
 * To change this template use File|Setting|File Templates.
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    private static Logger log = Logger.getLogger(AdminDaoImpl.class);
    private SessionFactory factory;

    @Autowired
    public AdminDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    public AdminDaoImpl() {

    }


    @Override
    public void create(Administrator administrator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(administrator);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("crate method", e);
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
    }

    @Override
    public Administrator read(long id) {
        Session session = factory.openSession();

        try {
            return (Administrator) session.get(Administrator.class, id);
        } catch (HibernateException e) {
            log.error("read Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Administrator administrator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(administrator);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("update Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Administrator administrator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(administrator);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("delete Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Administrator> findAll() {
        Session session = factory.openSession();

        try {
            return session.createCriteria(Administrator.class).list();

        } catch (HibernateException e) {
            log.error("findAll method");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
