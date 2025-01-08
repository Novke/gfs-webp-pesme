package gfs.webp.pesme.validation;

import gfs.webp.pesme.entity.Pesma;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PesmaPP extends AbstractPP {

    public void checkAzuriraj(Pesma pesma){
        if (pesma.getDatumIzdanja() == null) deny("Datum izdanja nije postavljen!");
        if (pesma.getDatumIzdanja().isAfter(LocalDate.now())) deny("Datum izdanja je u buducnosti!");
        if (pesma.getText()==null || pesma.getText().isBlank()) deny("Text je obrisan!");
    }

}
