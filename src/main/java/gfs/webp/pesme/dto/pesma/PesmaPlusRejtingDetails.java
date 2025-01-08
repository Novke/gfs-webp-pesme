package gfs.webp.pesme.dto.pesma;

import gfs.webp.pesme.dto.autor.AutorInfo;
import gfs.webp.pesme.dto.rejting.PesmaRejtingInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesmaPlusRejtingDetails {

    private Long id;
    private String naslov;
    private String text;
    private LocalDate datumIzdanja;
    private AutorInfo autor;
    private List<PesmaZanrInfo> zanrovi;
    private List<PesmaRejtingInfo> rejtinzi;
}
