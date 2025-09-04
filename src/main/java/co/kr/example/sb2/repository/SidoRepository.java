package co.kr.example.sb2.repository;

import co.kr.example.sb2.entity.Sido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SidoRepository extends JpaRepository<Sido, Integer> {
    
    @Query("SELECT s FROM Sido s ORDER BY s.seq DESC")
    Page<Sido> findAllOrderBySeqDesc(Pageable pageable);
}