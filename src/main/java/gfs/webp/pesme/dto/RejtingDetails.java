package gfs.webp.pesme.dto;

import gfs.webp.pesme.dto.kriticar.KriticarInfo;
import gfs.webp.pesme.dto.pesma.PesmaInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RejtingDetails {
    private Long id;
    private Integer ocena;
    private LocalDate datumOcenjivanja;
    private PesmaInfo pesma;
    private KriticarInfo kriticar;
}
