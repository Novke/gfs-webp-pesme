package gfs.webp.pesme.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rejting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ocena;
    private LocalDate datumOcenjivanja;

    @ManyToOne(optional = false)
    private Pesma pesma;

    @ManyToOne(optional = false)
    private Kriticar kriticar;
}
