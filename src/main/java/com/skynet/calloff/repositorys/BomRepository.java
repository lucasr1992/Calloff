package com.skynet.calloff.repositorys;

import com.skynet.calloff.domains.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomRepository extends JpaRepository<Bom, Long> {
  List<Bom> findByPartnumber(Long id);
}
