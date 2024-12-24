package gfs.webp.pesme.dto.autor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateAutorCmd {
    @NotNull(message = "Ime nije popunjeno!")
    @Size(min = 2, message = "Minimum 2 karaktera moraju biti u imenu")
    private String ime;
    @NotNull(message = "Prezime mora biti popunjeno")
    @Size(min = 2, message = "Minimum 2 karaktera moraju biti u prezimenu")
    private String prezime;
    @NotNull(message = "Datum rodjenja nije popunjen!")
    private LocalDate datumRodjenja;
}
