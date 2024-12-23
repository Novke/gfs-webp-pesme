package gfs.webp.pesme.repository;

import gfs.webp.pesme.entity.Kriticar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KriticarRepository extends JpaRepository<Kriticar, Long> {
}
