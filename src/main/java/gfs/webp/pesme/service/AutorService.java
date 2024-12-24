package gfs.webp.pesme.service;

import gfs.webp.pesme.dto.autor.AutorInfo;
import gfs.webp.pesme.dto.autor.CreateAutorCmd;
import gfs.webp.pesme.entity.Autor;
import gfs.webp.pesme.exceptions.SysException;
import gfs.webp.pesme.repository.AutorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Transactional
public class AutorService {

    private final AutorRepository autorRepository;
    private final ModelMapper mapper;

    public List<AutorInfo> getAutore(){
        return autorRepository.findAll().stream().map(a ->
                mapper.map(a, AutorInfo.class))
                .toList();
    }

    public AutorInfo kreirajAutora(CreateAutorCmd cmd){

        var datum = cmd.getDatumRodjenja();
        var now = LocalDate.now();

        //VALIDACIJA
        if (datum.isAfter(now)) throw new SysException("Datum rodjenja mora biti u proslosti!", BAD_REQUEST.value());
        if (datum.plusYears(18).isAfter(now)) throw new SysException("Kriticar mora biti punoletan!", BAD_REQUEST.value());

        return mapper.map(autorRepository.save(
                mapper.map(cmd, Autor.class)),
                AutorInfo.class);
    }

    public void obrisiAutora(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new SysException("Autor ne postoji! ID = " + id, 404));

        if (!autor.getPesme().isEmpty())
            throw new SysException("Nemoguce obrisati autora jer postoje pesme zapamcene u sistemu", BAD_REQUEST.value());

        autorRepository.delete(autor);
    }
}
