package gfs.webp.pesme.dto.rejting;

import gfs.webp.pesme.dto.kriticar.RejtingKriticarInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesmaRejtingInfo {
    private Integer ocena;
    private LocalDate datumOcenjivanja;
    private RejtingKriticarInfo kriticar;
}
