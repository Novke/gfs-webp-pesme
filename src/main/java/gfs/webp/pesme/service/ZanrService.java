package gfs.webp.pesme.service;

import gfs.webp.pesme.dto.zanr.CreateZanrCmd;
import gfs.webp.pesme.dto.zanr.ZanrInfo;
import gfs.webp.pesme.entity.Zanr;
import gfs.webp.pesme.repository.ZanrRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ZanrService {

    private final ZanrRepository zanrRepository;
    private final ModelMapper mapper;

    public List<ZanrInfo> getZanrove() {
        return zanrRepository.findAll().stream().map(z ->
                        mapper.map(z, ZanrInfo.class))
                .toList();
    }

    public ZanrInfo kreirajZanr(CreateZanrCmd cmd) {
        return mapper.map(zanrRepository.save(
                mapper.map(cmd, Zanr.class)
        ), ZanrInfo.class);
    }
}
