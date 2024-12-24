package gfs.webp.pesme.rest;

import gfs.webp.pesme.dto.pesma.CreatePesmaCmd;
import gfs.webp.pesme.dto.pesma.PesmaInfo;
import gfs.webp.pesme.service.PesmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pesma")
public class PesmaRest {

    private final PesmaService pesmaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<PesmaInfo> getPesme(){
        return pesmaService.getPesme();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    PesmaInfo kreirajPesmu(@RequestBody @Valid CreatePesmaCmd cmd){
        return pesmaService.kreirajPesmu(cmd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void obrisiPesmu(@PathVariable Long id){
        pesmaService.obrisiPesmu(id);
    }
}
