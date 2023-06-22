package ua.csgo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.csgo.domain.model.SkinPrice;

@Repository
public interface SkinPriceRepository extends JpaRepository<SkinPrice, String> {
}
