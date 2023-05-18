package com.example.newsflash.controller;

import com.example.newsflash.model.Comments;
import com.example.newsflash.model.Preferences;
import com.example.newsflash.service.PreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/preferences")
public class PreferencesController {
    @Autowired
    private final PreferencesService preferencesService;

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<List<Preferences>> getPreferencesByUserId(@PathVariable("id") Long id){
        List<Preferences> preferences = preferencesService.getPreferencesByUserId(id);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }

    @GetMapping("/getCategoriesByUserId/{id}")
    public ResponseEntity<Optional<Preferences>> getCategoriesPreferencesByUserId(@PathVariable("id") Long id){
        Optional<Preferences> preferences = preferencesService.getCategoriesPreferencesByUserId(id);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }

    @GetMapping("/getSourcesByUserId/{id}")
    public ResponseEntity<Optional<Preferences>> getSourcesPreferencesByUserId(@PathVariable("id") Long id){
        Optional<Preferences> preferences = preferencesService.getSourcesPreferencesByUserId(id);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }

    @GetMapping("/getCountriesByUserId/{id}")
    public ResponseEntity<Optional<Preferences>> getCountriesPreferencesByUserId(@PathVariable("id") Long id){
        Optional<Preferences> preferences = preferencesService.getCountriesPreferencesByUserId(id);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Preferences> addPreferences(@RequestBody Preferences preferences){
        Preferences preferences1 = preferencesService.addPreferences(preferences);
        return new ResponseEntity<>(preferences1, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Preferences> updatePreferences(@PathVariable("id") Long id, @RequestBody Preferences preferences){
        Preferences existingPreferences = preferencesService.findPreferencesById(id);
        if (existingPreferences == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingPreferences.setPreference(preferences.getPreference());
        existingPreferences.setType(preferences.getType());
        existingPreferences.setUserId(preferences.getUserId());

        Preferences updatedPreferences = preferencesService.updatePreferences(existingPreferences);
        return new ResponseEntity<>(updatedPreferences, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePreferences(@PathVariable("id") Long id){
        preferencesService.deletePreferences(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
