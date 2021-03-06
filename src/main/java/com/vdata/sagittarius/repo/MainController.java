package com.vdata.sagittarius.repo;

import com.vdata.sagittarius.entity.Client;
import com.vdata.sagittarius.entity.PersonType;
import com.vdata.sagittarius.entity.PhysicalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demoController") // This means URL's start with /demoController (after Application path)
public class MainController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ClientRepository clientRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam PersonType personType
            , @RequestParam String city, @RequestParam String street ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client client = new PhysicalClient();
        client.setPersonType(personType);
        client.setCity(city);
        client.setStreet(street);

        clientRepository.save(client);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        // This returns a JSON or XML with the Clients

        return clientRepository.findAll();
    }

}