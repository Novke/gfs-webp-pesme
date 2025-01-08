package gfs.webp.pesme.service;

import gfs.webp.pesme.dto.RejtingDetails;
import gfs.webp.pesme.dto.pesma.*;
import gfs.webp.pesme.entity.Autor;
import gfs.webp.pesme.entity.Kriticar;
import gfs.webp.pesme.entity.Pesma;
import gfs.webp.pesme.entity.Rejting;
import gfs.webp.pesme.exceptions.SysException;
import gfs.webp.pesme.repository.AutorRepository;
import gfs.webp.pesme.repository.KriticarRepository;
import gfs.webp.pesme.repository.PesmaRepository;
import gfs.webp.pesme.repository.RejtingRepository;
import gfs.webp.pesme.validation.PesmaPP;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PesmaService {

    private final PesmaRepository pesmaRepository;
    private final AutorRepository autorRepository;
    private final KriticarRepository kriticarRepository;
    private final RejtingRepository rejtingRepository;
    private final PesmaPP pesmaPP;
    private final ModelMapper mapper;

    public List<PesmaInfo> getPesme(){
        return pesmaRepository.findAll().stream().map(p ->
                mapper.map(p, PesmaInfo.class)
        ).toList();
    }

    public PesmaInfo kreirajPesmu(CreatePesmaCmd cmd){
        Autor autor = autorRepository.findById(cmd.getAutorId())
                .orElseThrow(() -> new SysException("Autor ne postoji! ID = " + cmd.getAutorId(), 404));

        Pesma pesma = mapper.map(cmd, Pesma.class);
        pesma.setAutor(autor);

        log.info("CMD: " + cmd);
        log.info("Pesma: " + pesma);
        log.info("Autor: " + autor);

        Pesma saved = pesmaRepository.save(
                pesma);
        log.info("Saved pesma:" + saved);

        return mapper.map(saved,
                PesmaInfo.class);
    }

    public void obrisiPesmu(Long id){
        pesmaRepository.findById(id)
                .orElseThrow(() -> new SysException("Pesma ne postoji! ID = " + id, 404));

        pesmaRepository.deleteById(id);
    }

    public PesmaDetails azurirajPesmu(UpdatePesmaCmd cmd) {
        Pesma pesma = pesmaRepository.findById(cmd.getPesmaId())
                .orElseThrow(() -> new SysException("Pesma ne postoji! ID = " + cmd.getPesmaId(), 404));

        mapper.map(cmd, pesma);
        pesmaPP.checkAzuriraj(pesma);

        return mapper.map(pesmaRepository.save(pesma), PesmaDetails.class);
    }

    public RejtingDetails oceniPesmu(RatePesmaCmd cmd) {
        Pesma pesma = pesmaRepository.findById(cmd.getPesmaId())
                .orElseThrow(() -> new SysException("Pesma ne postoji! ID = " + cmd.getPesmaId(), 404));
        Kriticar kriticar = kriticarRepository.findById(cmd.getKriticarId())
                .orElseThrow(() -> new SysException("Kriticar ne postoji! ID = " + cmd.getKriticarId(), 404));

        Rejting rejting = rejtingRepository.findByPesmaAndKriticar(pesma, kriticar)
                .orElse(Rejting.builder()
                        .pesma(pesma)
                        .kriticar(kriticar)
                        .build());

        rejting.setOcena(cmd.getOcena());
        rejting.setDatumOcenjivanja(LocalDate.now());
        return mapper.map(rejtingRepository.save(rejting), RejtingDetails.class);
    }
}
