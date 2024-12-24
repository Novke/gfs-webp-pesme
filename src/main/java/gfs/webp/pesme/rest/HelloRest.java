package gfs.webp.pesme.rest;

import gfs.webp.pesme.util.Initializer;
//import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping
public class HelloRest {

    private final Initializer initializer;

    public HelloRest(Initializer initializer) {
        this.initializer = initializer;
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    String hello(){
        return "Hello world!";
    }

    @PostMapping("/init")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void initialize(){
        initializer.initialize(false);
    }
    @PostMapping("/init/force")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void forceInitialize(){
        initializer.initialize(true);
    }

}
