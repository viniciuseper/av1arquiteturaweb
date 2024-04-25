package com.example.RestAPI.controller;
import com.example.RestAPI.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    UserService service = new UserService ();

    @GetMapping("/noticiasereleases")
    public String obterNotReleases(){
        return service.obterNotReleases();
    }

    @GetMapping("/noticias")
    public String obterNoticias(){
        return service.obterNoticias();
    }

    @GetMapping("releases")
    public String obterReleases(){
        return service.obterReleases();
    }
}

