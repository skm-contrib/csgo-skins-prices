package ua.csgo.domain.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.csgo.domain.model.Skin;

import java.util.List;

@Repository
public interface SkinRepository extends JpaRepository<Skin, String> {
    /*    @Query("select s from Skin s where (lower(s.name) like lower(concat('%', :search, '%'))) and (lower(s.weaponType) like lower(concat('%', :weapon_type, '%'))) and (lower(s.weapon) like lower(concat('%', :weapon, '%')))")
        List<Skin> findAll(Pageable page, @Param("search") String search, @Param("weapon_type") String weaponType, @Param("weapon") String weapon);
      */
    @Query("SELECT s " +
            "FROM Skin s " +
            "WHERE (LOWER(s.name) LIKE CONCAT('%', LOWER(:search), '%') OR LOWER(s.description) LIKE CONCAT('%', LOWER(:search), '%') OR :search IS NULL) " +
            "AND (LOWER(s.weapon) LIKE CONCAT('%', LOWER(:weapon), '%') OR :weapon IS NULL) " +
            "AND (LOWER(s.weaponType) LIKE CONCAT('%', LOWER(:weapon_type), '%') OR :weapon_type IS NULL)")
    List<Skin> findAll(Pageable page, @Param("search") String search, @Param("weapon_type") String weaponType, @Param("weapon") String weapon);

    List<Skin> findAllByNameIsContainingIgnoreCaseAndAndWeaponIsContainingIgnoreCaseAndWeaponTypeIsWithinIgnoreCase(Pageable page, String name, String weaponType, String weapon);

}