package gfs.webp.pesme.repository;

import gfs.webp.pesme.entity.Pesma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesmaRepository extends JpaRepository<Pesma, Long> {
}
