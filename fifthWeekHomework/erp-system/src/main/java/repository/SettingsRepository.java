package main.java.repository;

import main.java.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SettingsRepository extends JpaRepository<Settings,Long> {
    Optional<Settings> findByKey(String key);
    @Query(value = "select s from Settings s where s.uuid=:uuid")
    Optional<Settings> findSettingsByUuid(@Param("uuid") UUID uuid);

}
