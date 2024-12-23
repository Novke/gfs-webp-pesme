package gfs.webp.pesme.rest;

import gfs.webp.pesme.dto.zanr.CreateZanrCmd;
import gfs.webp.pesme.dto.zanr.ZanrInfo;
import gfs.webp.pesme.service.ZanrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zanr")
@RequiredArgsConstructor
public class ZanrRest {

    private final ZanrService zanrService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ZanrInfo> getZanrove(){
        return zanrService.getZanrove();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ZanrInfo kreirajZanr(@RequestBody @Valid CreateZanrCmd cmd){
        return zanrService.kreirajZanr(cmd);
    }

}
