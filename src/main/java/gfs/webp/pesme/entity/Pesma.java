package gfs.webp.pesme.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pesma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naslov;
    private String text;
    private LocalDate datumIzdanja;

    @ManyToOne(optional = false)
    private Autor autor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesma")
    private Set<Rejting> rejtinzi;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pesma_zanr",
    joinColumns = @JoinColumn(name = "pesmaId"),
    inverseJoinColumns = @JoinColumn(name = "zanrId"))
    private Set<Zanr> zanrovi;
}
