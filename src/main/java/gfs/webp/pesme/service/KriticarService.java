package gfs.webp.pesme.service;

import gfs.webp.pesme.dto.kriticar.CreateKriticarCmd;
import gfs.webp.pesme.dto.kriticar.KriticarInfo;
import gfs.webp.pesme.entity.Kriticar;
import gfs.webp.pesme.exceptions.SysException;
import gfs.webp.pesme.repository.KriticarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class KriticarService {

    private final KriticarRepository kriticarRepository;
    private final ModelMapper mapper;

    public List<KriticarInfo> getKriticare(){
        return kriticarRepository.findAll().stream().map(k ->
            mapper.map(k, KriticarInfo.class)
        ).toList();
    }
    public KriticarInfo kreirajKriticara(CreateKriticarCmd cmd){
        return mapper.map(kriticarRepository.save(
                mapper.map(cmd, Kriticar.class)),
                KriticarInfo.class);
    }

    public void obrisiKriticara(Long id) {
        kriticarRepository.findById(id)
                .orElseThrow(() -> new SysException("Kriticar ne postoji! ID = " + id, 404));

        kriticarRepository.deleteById(id);
    }
}
