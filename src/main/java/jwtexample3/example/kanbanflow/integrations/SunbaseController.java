package jwtexample3.example.kanbanflow.integrations;

import jwtexample3.example.kanbanflow.apiResponse.SunbaseTemplatesResp;
import jwtexample3.example.kanbanflow.service.SunbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sunbase")
public class SunbaseController {
    @Autowired
    SunbaseService sunbaseService;

    @GetMapping("/templates")
    public ResponseEntity<?> getTemplates(){
        SunbaseTemplatesResp res = sunbaseService.getTemplates();
        System.out.println(res+"<-----");

        return  new ResponseEntity<>("HI Aniket here is your sunbase TemplateDat", HttpStatus.OK);
    }
}
