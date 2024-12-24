package gfs.webp.pesme.dto.autor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AutorInfo {
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
}
