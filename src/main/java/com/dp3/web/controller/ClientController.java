package com.dp3.web.controller;

import com.dp3.dao.ClientRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/all")
    public ModelAndView stock(Model model){
        ModelAndView client = new ModelAndView("client");
        model.addAttribute("clientList", clientRepository.findAll());
        return client;
    }

    @PostMapping("/createClient")
    public ModelAndView createClient(Model model, @Valid Client client){
        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return new ModelAndView("redirect:/clients/all");
    }

    @GetMapping(value = "/client/{clientName}")
    public ResponseEntity<Client> getClientByClientName(@PathVariable("clientName") String clientName){
        Client client = clientRepository.findOne(clientName);
        if(client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/edit/{clientName}")
    public ResponseEntity<Client> updateClient(@PathVariable("clientName") String clientName,
                                               @Valid @RequestBody Client client){
        Client clientData = clientRepository.findOne(clientName);
        if(clientData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientData.setClientName(client.getClientName());
        clientData.setClientLocation(client.getClientLocation());
        clientData.setClientPhone(client.getClientPhone());
        Client updateClient = clientRepository.save(clientData);
        return new ResponseEntity<>(updateClient,HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{clientCode}", method = RequestMethod.POST)
    public ModelAndView deleteClient(Model model,@PathVariable("clientCode") String clientCode){
        model.addAttribute("clientList", clientRepository.findAll());
        clientRepository.delete(clientCode);
        return new ModelAndView("redirect:/clients/all");
    }

}
