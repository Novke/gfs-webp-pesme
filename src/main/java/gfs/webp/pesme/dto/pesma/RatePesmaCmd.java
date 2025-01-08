package gfs.webp.pesme.dto.pesma;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatePesmaCmd {

    @NotNull(message = "Ocena nije postavljena")
    @Min(value = 0, message = "Ocena mora biti pozitivan broj")
    @Max(value = 5, message = "Ocena mora biti u intervalu 0-5")
    private Integer ocena;

    @NotNull(message = "Pesma nije odabrana")
    private Long pesmaId;

    @NotNull(message = "Kriticar nije odabran")
    private Long kriticarId;
}
