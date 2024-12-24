package gfs.webp.pesme.rest;

import gfs.webp.pesme.dto.kriticar.CreateKriticarCmd;
import gfs.webp.pesme.dto.kriticar.KriticarInfo;
import gfs.webp.pesme.service.KriticarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kriticar")
@RequiredArgsConstructor
public class KriticarRest {

    private final KriticarService kriticarService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<KriticarInfo> getKriticare(){
        return kriticarService.getKriticare();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    KriticarInfo kreirajKriticara(@RequestBody @Valid CreateKriticarCmd cmd){
        return kriticarService.kreirajKriticara(cmd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void obrisiKriticara(@PathVariable Long id){
        kriticarService.obrisiKriticara(id);
    }

}
