package gfs.webp.pesme.repository;

import gfs.webp.pesme.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {
}