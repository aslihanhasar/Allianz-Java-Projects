package main.java.controller;

import main.java.dto.BaseResponse;
import main.java.dto.SettingsDTO;
import main.java.entity.Settings;
import main.java.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/settings")
@RequiredArgsConstructor
public class SettingsController {
    private final SettingsService settingsService;

    @GetMapping()
    public ResponseEntity<List<Settings>> getSettings() {
        List<Settings> settings = settingsService.getAllSettings();
        return ResponseEntity.ok(settings);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<SettingsDTO>> createSetting(
            @RequestBody SettingsDTO settingsDTO) {
        SettingsDTO newSetting = settingsService.save(settingsDTO);
        var response = BaseResponse.<SettingsDTO>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(newSetting)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<SettingsDTO>> updateSetting(@RequestBody SettingsDTO settingsDTO) {
        SettingsDTO updatedSetting = settingsService.update(settingsDTO);
        var response = BaseResponse.<SettingsDTO>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(updatedSetting)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public void deleteSetting(@PathVariable("uuid") UUID uuid) {
        settingsService.delete(uuid);
    }
}
