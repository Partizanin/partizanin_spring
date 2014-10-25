package hw11.service.operator;


import hw11.model.domain.Operator;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 14.09.2014
 * Time:  13:44
 * To change this template use File|Setting|File Templates.
 */
public interface OperatorService {

    void create(Operator operator);

    Operator read(long id);

    void update(Operator operator);

    void delete(Operator operator);

    List<Operator> findAll();
}
