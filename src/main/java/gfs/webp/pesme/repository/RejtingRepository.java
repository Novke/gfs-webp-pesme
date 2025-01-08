package gfs.webp.pesme.repository;

import gfs.webp.pesme.entity.Kriticar;
import gfs.webp.pesme.entity.Pesma;
import gfs.webp.pesme.entity.Rejting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RejtingRepository extends JpaRepository<Rejting, Long> {
    Optional<Rejting> findByPesmaAndKriticar(Pesma pesma, Kriticar kriticar);
}
