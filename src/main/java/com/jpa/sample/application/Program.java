package com.jpa.sample.application;

import com.jpa.sample.dao.ClientDAO;
import com.jpa.sample.domain.Client;

import java.util.List;

public class Program {

    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();

//        clientDAO.save(new Client("Badanha", "badanha@gmail.com"));
//        clientDAO.save(new Client("Ciclano de Tal", "ciclano.tal@gmail.com"));
//        clientDAO.save(new Client("Beltrano de Tal", "beltrano.tal@gmail.com"));
        System.out.println("INSERT: OK!");

        Client client = clientDAO.findById(1L);
        System.out.println(client);
        System.out.println("FIND ONE: OK!");

//        client.setName("John Doe");
//        client.setEmail("john.doe@gmail.com");
//        clientDAO.update(client);
        System.out.println("UPDATE: Ok!");

//        client = clientDAO.findById(3L);
//        clientDAO.delete(client);
        System.out.println("DELETE: Ok!");

        List<Client> clients = clientDAO.findAll();
        clients.forEach(System.out::println);
        clients = clientDAO.findAll(5, 6);
        System.out.println();
        clients.forEach(System.out::println);
        System.out.println("\nFIND ALL: Ok!");
    }
}
