package gfs.webp.pesme.dto.pesma;

import gfs.webp.pesme.dto.autor.AutorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesmaDetails {

    private Long id;
    private String naslov;
    private String text;
    private LocalDate datumIzdanja;
    private AutorInfo autor;
    private List<PesmaZanrInfo> zanrovi;
}
