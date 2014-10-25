package hw11.model.dao.admin;

import hw11.model.domain.Administrator;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 14.09.2014
 * Time:  13:35
 * To change this template use File|Setting|File Templates.
 */
public interface AdminDao {

    void create(Administrator administrator);

    Administrator read(long id);

    void update(Administrator administrator);

    void delete(Administrator administrator);

    List<Administrator> findAll();
}
