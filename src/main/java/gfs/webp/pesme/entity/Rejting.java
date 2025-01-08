package gfs.webp.pesme.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
