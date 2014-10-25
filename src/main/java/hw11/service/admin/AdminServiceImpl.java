package hw11.service.admin;

import hw11.model.dao.admin.AdminDaoImpl;
import hw11.model.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 14.09.2014
 * Time:  13:44
 * To change this template use File|Setting|File Templates.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDaoImpl adminDao;

    public AdminServiceImpl() {

    }

    public AdminServiceImpl(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void create(Administrator administrator) {
        adminDao.create(administrator);
    }

    @Override
    public Administrator read(long id) {
        return adminDao.read(id);
    }

    @Override
    public void update(Administrator administrator) {
        adminDao.update(administrator);
    }

    @Override
    public void delete(Administrator administrator) {
        adminDao.delete(administrator);
    }

    @Override
    public List<Administrator> findAll() {
        List<Administrator> list = new ArrayList<>();
        try {
            list = adminDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }
}
