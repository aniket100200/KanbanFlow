package jwtexample3.example.kanbanflow.service.Imp;

import jwtexample3.example.kanbanflow.apiResponse.SunbaseTemplatesResp;
import jwtexample3.example.kanbanflow.service.SunbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SunbaseServiceImp implements SunbaseService {

    final RestTemplate restTemplate;
    private String API = "https://server2.sunbasedata.com/sunbase/portal/api/fieldtemplate_api.jsp";

    @Autowired
    public SunbaseServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SunbaseTemplatesResp getTemplates() {
            ResponseEntity<SunbaseTemplatesResp > res =  restTemplate.exchange(API, HttpMethod.GET,null, SunbaseTemplatesResp.class);
            SunbaseTemplatesResp sunbaseTemplatesResp = res.getBody();
            return  sunbaseTemplatesResp;
    }
}
