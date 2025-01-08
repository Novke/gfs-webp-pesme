package gfs.webp.pesme.service;

import gfs.webp.pesme.dto.pesma.CreatePesmaCmd;
import gfs.webp.pesme.dto.pesma.PesmaDetails;
import gfs.webp.pesme.dto.pesma.PesmaInfo;
import gfs.webp.pesme.dto.pesma.UpdatePesmaCmd;
import gfs.webp.pesme.entity.Autor;
import gfs.webp.pesme.entity.Pesma;
import gfs.webp.pesme.exceptions.SysException;
import gfs.webp.pesme.repository.AutorRepository;
import gfs.webp.pesme.repository.PesmaRepository;
import gfs.webp.pesme.validation.PesmaPP;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PesmaService {

    private final PesmaRepository pesmaRepository;
    private final AutorRepository autorRepository;
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
}
