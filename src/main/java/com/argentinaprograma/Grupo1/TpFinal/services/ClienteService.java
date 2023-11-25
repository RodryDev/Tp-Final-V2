package com.argentinaprograma.Grupo1.TpFinal.services;

import com.argentinaprograma.Grupo1.TpFinal.model.Cliente;
import com.argentinaprograma.Grupo1.TpFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ClienteService {
    ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    //Crud

    //Guardar

    public Integer guardar(Cliente c){
        return clienteRepository.save(c).getId();

    }



//Buscar Cliente por id

    public Cliente buscarPorId(Cliente id){
        return (clienteRepository.buscarPorId(id.getCuit(),
                id.getEmail(),id.getRazonSocial(),
                id.getNombre(),id.getApellido()));

    }

//Borrar por id

    public Cliente deleteById( Cliente id){
        return (clienteRepository.deleteById(id.getCuit(),id.getEmail(),id.getRazonSocial(),id.getNombre(),id.getNombre(),id.getApellido())
        );
    }







}












