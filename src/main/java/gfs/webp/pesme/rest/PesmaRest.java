package gfs.webp.pesme.rest;

import gfs.webp.pesme.dto.RejtingDetails;
import gfs.webp.pesme.dto.pesma.*;
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

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PesmaDetails azurirajPesmu(@RequestBody @Valid UpdatePesmaCmd cmd){
        return pesmaService.azurirajPesmu(cmd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void obrisiPesmu(@PathVariable Long id){
        pesmaService.obrisiPesmu(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    RejtingDetails oceniPesmu(@RequestBody @Valid RatePesmaCmd cmd){
        return pesmaService.oceniPesmu(cmd);
    }

    @DeleteMapping("/rejting/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void obrisiRejting(@PathVariable Long id){
        pesmaService.obrisiRejting(id);
    }
}
