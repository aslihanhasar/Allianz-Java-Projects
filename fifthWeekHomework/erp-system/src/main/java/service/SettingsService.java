package main.java.service;

import main.java.dto.SettingsDTO;
import main.java.entity.Settings;
import main.java.repository.SettingsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SettingsService {
    private final SettingsRepository settingsRepository;

    /**
     * Saves a new setting based on the provided `SettingsDTO`.
     *
     * @param settingsDTO The DTO object containing setting data to be saved.
     * @return A DTO object containing the saved setting's information.
     */
    public SettingsDTO save(SettingsDTO settingsDTO) {
        Settings savedSetting = buildSettingsAndSave(settingsDTO);
        return convertSettingToDTO(savedSetting);
    }

    /**
     * Retrieves a list of all settings currently stored in the system.
     *
     * @return A list of all setting records.
     */
    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }

    /**
     * Updates an existing setting's information based on the provided `SettingsDTO`.
     *
     * @param settingsDTO The DTO object containing updated setting data.
     * @return A DTO object containing the updated setting's information.
     * @throws RuntimeException if the specified setting does not exist.
     */
    public SettingsDTO update(SettingsDTO settingsDTO) {
        Optional<Settings> settingsOptional = settingsRepository.findByKey(settingsDTO.getKey());
        if (settingsOptional.isPresent()) {
            Settings setting = settingsOptional.get();
            setting.setKey(settingsDTO.getKey());
            Settings savedSetting = settingsRepository.save(setting);
            return convertSettingToDTO(savedSetting);
        }
        throw new RuntimeException("Setting not found");
    }

    /**
     * Deletes a setting by removing it from the database.
     *
     * @param uuid The UUID of the setting to delete.
     * @throws RuntimeException if the specified setting does not exist.
     */
    @Transactional
    public void delete(UUID uuid) {
        Settings setting = getSettingByUUID(uuid);
        if (setting != null) {
            settingsRepository.deleteById(setting.getId());
        } else {
            throw new RuntimeException("Setting not found");
        }
    }

    /**
     * Retrieves a setting by its UUID.
     *
     * @param uuid The UUID of the setting to retrieve.
     * @return The setting object if found, or null if not found.
     */
    public Settings getSettingByUUID(UUID uuid) {
        Optional<Settings> settingsOptional = settingsRepository.findSettingsByUuid(uuid);
        return settingsOptional.orElse(null);
    }

    /**
     * Retrieves the value of a setting by its key.
     *
     * @param key The key of the setting to retrieve.
     * @return The value of the setting if found.
     * @throws RuntimeException if the specified setting key does not exist.
     */
    public double getSettingValueByKey(String key) {
        Optional<Settings> settingsOptional = settingsRepository.findByKey(key);
        if (settingsOptional.isPresent()) {
            Settings setting = settingsOptional.get();
            return setting.getValue();
        }
        throw new RuntimeException("Setting value not found");
    }

    private Settings buildSettingsAndSave(SettingsDTO settingsDTO) {
        Settings newSetting = Settings
                .builder()
                .key(settingsDTO.getKey())
                .value(settingsDTO.getValue())
                .build();
        return settingsRepository.save(newSetting);
    }

    private SettingsDTO convertSettingToDTO(Settings setting) {
        return new SettingsDTO(setting.getKey(), setting.getValue());
    }

}
