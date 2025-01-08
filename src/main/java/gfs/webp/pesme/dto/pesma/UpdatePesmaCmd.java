package gfs.webp.pesme.dto.pesma;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePesmaCmd {
    @NotNull(message = "Nije odabrana pesma! Fali atribut pesmaId. ")
    private Long pesmaId;
    private String text;
    private LocalDate datumIzdanja;
}
