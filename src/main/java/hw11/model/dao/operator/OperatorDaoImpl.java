package hw11.model.dao.operator;

import hw11.model.domain.Operator;
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
public class OperatorDaoImpl implements OperatorDao {

    private static Logger log = Logger.getLogger(OperatorDaoImpl.class);
    private SessionFactory factory;

    @Autowired
    public OperatorDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    public OperatorDaoImpl() {

    }


    @Override
    public void create(Operator operator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(operator);
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
    public Operator read(long id) {
        Session session = factory.openSession();
        try {
            return (Operator) session.get(Operator.class, id);

        } catch (HibernateException e) {
            log.error("read Method");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Operator operator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(operator);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("update Method");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Operator operator) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(operator);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("delete Method");
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public List<Operator> findAll() {

        Session session = factory.openSession();

        try {
            return session.createCriteria(Operator.class).list();
        } catch (HibernateException e) {
            log.error("findAll method");
            e.printStackTrace();
        }
        return null;
    }
}