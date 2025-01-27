package gfs.webp.pesme.dto.kriticar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KriticarInfo {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
}
