package gfs.webp.pesme.rest;

import gfs.webp.pesme.dto.autor.AutorInfo;
import gfs.webp.pesme.dto.autor.CreateAutorCmd;
import gfs.webp.pesme.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorRest {

    private final AutorService autorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<AutorInfo> getautore(){
        return autorService.getAutore();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    AutorInfo kreirajAutora(@RequestBody @Valid CreateAutorCmd cmd){
        return autorService.kreirajAutora(cmd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void obrisiKriticara(@PathVariable Long id){
        autorService.obrisiAutora(id);
    }
}
