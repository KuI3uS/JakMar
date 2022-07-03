package pl.pjatk.JakMar;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPService {
    final Repository2 repository;
    final RestTemplate restTemplate;

    public NBPService(Repository2 repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public NBPEntity getWaluta(  String code,String waluta, String startDate, String endDate) {
        NBPEntity exchange = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/" + code
                +"/"+waluta+"/"+startDate+"/"+endDate+"/", NBPEntity.class).getBody();
        return repository.save(exchange);

    }

    public String getZloto() {
        String exchange = restTemplate.getForEntity("https://api.nbp.pl/api/cenyzlota/", String.class).getBody();

        return exchange;

    }

}