package gfs.webp.pesme.dto.zanr;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateZanrCmd {

    @NotNull(message = "Nije prosledjen naziv!!")
    @Size(min = 2, message = "Naziv zanra mora imati minimum 2 slova")
    private String naziv;
}
