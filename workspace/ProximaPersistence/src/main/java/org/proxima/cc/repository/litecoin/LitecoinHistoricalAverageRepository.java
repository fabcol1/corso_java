package org.proxima.cc.repository.litecoin;

import org.proxima.cc.entities.litecoin.LitecoinHistoricalAverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitecoinHistoricalAverageRepository extends JpaRepository<LitecoinHistoricalAverage, Integer> {
}
