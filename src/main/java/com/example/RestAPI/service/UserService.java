package com.example.RestAPI.service;

import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private String consultarURL(String apiURL) {
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();;
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String obterNotReleases() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias");
    }

    public String obterNoticias() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia");
    }

    public String obterReleases() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release");
    }

    public UserEntity inserirnoticia(UserEntity bdnoticias) {
        return UserRepository.save(bdnoticias);
    }

    public UserEntity inserirrelease(UserEntity bdnoticias) {
        return UserRepository.save(bdnoticias);
    }


}
