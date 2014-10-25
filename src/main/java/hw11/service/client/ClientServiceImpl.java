package hw11.service.client;

import hw11.model.dao.client.ClientDaoImpl;
import hw11.model.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 20.09.2014
 * Time:  10:27
 * To change this template use File|Setting|File Templates.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDaoImpl clientDao;


    public ClientServiceImpl(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;

    }

    public ClientServiceImpl() {
    }

    @Override
    public void create(Client client) {

        clientDao.create(client);
    }

    @Override
    public Client read(long id) {
        return clientDao.read(id);
    }

    @Override
    public void update(Client client) {
        clientDao.update(client);
    }

    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Override
    public List<Client> findAll() {
        List<Client> list = new ArrayList<>();
        try {
            list = clientDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }
}
