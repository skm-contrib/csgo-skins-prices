package ua.csgo.domain.repository;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.csgo.domain.model.Skin;

import java.util.List;

@Repository
public interface SkinRepository extends JpaRepository<Skin, String> {

    @Query("select s " +
            "from Skin s " +
            "where (s.weaponType = :weaponType or :weaponType is null)" +
            "and (s.weapon = :weapon or :weapon is null)" +
            "and (s.name like concat('%', :search, '%') or :search is null)")
    List<Skin> findAll(PageRequest of, String weaponType, String weapon, String search, Sort sort);

    @Query("select count(s) " +
            "from Skin s " +
            "where (s.weaponType = :weaponType or :weaponType is null)" +
            "and (s.weapon = :weapon or :weapon is null)" +
            "and (s.name like concat('%', :search, '%') or :search is null)")
    long count(String search, String weapon, String weaponType);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM User u JOIN u.favorites s WHERE u.id = :id AND s.skinId = :skinId")
    boolean isSkinInFavorites(int id, String skinId);
}