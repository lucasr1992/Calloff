package com.skynet.calloff.repositorys;

import com.skynet.calloff.domains.Partnumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnumberRepository extends JpaRepository<Partnumber, Long> {
  List<Partnumber> findByStatus(String status);
}
