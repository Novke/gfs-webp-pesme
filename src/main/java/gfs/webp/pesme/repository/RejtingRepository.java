package gfs.webp.pesme.repository;

import gfs.webp.pesme.entity.Rejting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejtingRepository extends JpaRepository<Rejting, Long> {
}
