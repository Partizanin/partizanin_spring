package hw11.service.client;

import hw11.model.domain.Client;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 14.09.2014
 * Time:  13:44
 * To change this template use File|Setting|File Templates.
 */
public interface ClientService {

    void create(Client client);

    Client read(long id);

    void update(Client client);

    void delete(Client client);

    List<Client> findAll();
}
