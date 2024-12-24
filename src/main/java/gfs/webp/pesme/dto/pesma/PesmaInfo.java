package gfs.webp.pesme.dto.pesma;

import gfs.webp.pesme.dto.autor.AutorInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PesmaInfo {
    private Long id;
    private String naslov;
//    private String text;
//    private LocalDate datumIzdanja;
    private AutorInfo autor;
}
