package hw11.service.operator;

import hw11.model.dao.operator.OperatorDaoImpl;
import hw11.model.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 20.09.2014
 * Time:  11:04
 * To change this template use File|Setting|File Templates.
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    private OperatorDaoImpl dao;

    @Autowired
    public OperatorServiceImpl(OperatorDaoImpl dao) {

        this.dao = dao;
    }


    public OperatorServiceImpl() {
    }

    @Override
    public void create(Operator operator) {
        dao.create(operator);
    }

    @Override
    public Operator read(long id) {
        return dao.read(id);
    }

    @Override
    public void update(Operator operator) {
        dao.update(operator);
    }

    @Override
    public void delete(Operator operator) {

        dao.delete(operator);
    }

    @Override
    public List<Operator> findAll() {
        List<Operator> list = new ArrayList<>();
        try {
            list = dao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }
}
