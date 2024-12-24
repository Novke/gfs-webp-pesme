package gfs.webp.pesme.dto.pesma;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreatePesmaCmd {
    @NotNull(message = "Naslov nije popunjen")
    @Size(min = 1, message = "Naslov mora imati baren 1 karakter")
    private String naslov;
    @NotNull(message = "Text nije popunjen")
    @Size(min = 5, message = "Tekst mora imati barem 5 karaktera")
    private String text;
//    @NotNull
    private LocalDate datumIzdanja = LocalDate.now();
    @NotNull
    private Long autorId;
}
