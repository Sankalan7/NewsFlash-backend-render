package com.example.newsflash.service;

import com.example.newsflash.model.Comments;
import com.example.newsflash.model.Preferences;
import com.example.newsflash.repository.PreferencesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PreferencesService {
    @Autowired
    private final PreferencesRepository preferencesRepository;
    public Preferences findPreferencesById(Long id){
        Optional<Preferences> preferencesOptional = preferencesRepository.findById(id);
        return preferencesOptional.orElse(null);
    }
    public List<Preferences> getPreferencesByUserId(Long userId){
        List<Preferences> preferencesList = preferencesRepository.getPreferencesByUserId(userId);
        return preferencesList;
    }
    public Optional<Preferences> getCategoriesPreferencesByUserId(Long userId){
        Optional<Preferences> preferencesList = preferencesRepository.getCategoriesPreferencesByUserId(userId);
        return preferencesList;
    }
    public Optional<Preferences> getSourcesPreferencesByUserId(Long userId){
        Optional<Preferences> preferencesList = preferencesRepository.getSourcesPreferencesByUserId(userId);
        return preferencesList;
    }
    public Optional<Preferences> getCountriesPreferencesByUserId(Long userId){
        Optional<Preferences> preferencesList = preferencesRepository.getCountriesPreferencesByUserId(userId);
        return preferencesList;
    }

    public Preferences addPreferences(Preferences preferences){
        return preferencesRepository.save(preferences);
    }

    public Preferences updatePreferences(Preferences preferences){
        return preferencesRepository.save(preferences);
    }

    public void deletePreferences(Long id){
        preferencesRepository.deleteById(id);
    }
}
