package gfs.webp.pesme.util;

import gfs.webp.pesme.entity.Zanr;
import gfs.webp.pesme.repository.ZanrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final ZanrRepository zanrRepository;

    public void initialize(boolean force){
        zanrRepository.deleteAll();
        Zanr zanrSmesne = zanrRepository.save(new Zanr(null, "Smesne"));
        Zanr zanrLjubavne = zanrRepository.save(new Zanr(null, "Ljubavne"));
    }

}
