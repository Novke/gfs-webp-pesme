package gfs.webp.pesme.dto.kriticar;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateKriticarCmd {
    @NotNull(message = "Ime nije popunjeno!")
    @Size(min = 2, message = "Minimum 2 karaktera moraju biti u imenu")
    private String ime;
    @NotNull(message = "Prezime mora biti popunjeno")
    @Size(min = 2, message = "Minimum 2 karaktera moraju biti u prezimenu")
    private String prezime;
    @NotNull(message = "Email nije popunjen!")
    @Email(message = "Email je loseg formata!")
    private String email;
}
