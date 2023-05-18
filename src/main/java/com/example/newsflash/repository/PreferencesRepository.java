package com.example.newsflash.repository;

import com.example.newsflash.model.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
    @Query("SELECT p from Preferences p WHERE p.userId = ?1")
    List<Preferences> getPreferencesByUserId(Long userId);

    @Query("SELECT p from Preferences p WHERE p.userId = ?1 and p.type='categories'")
    Optional<Preferences> getCategoriesPreferencesByUserId(Long userId);

    @Query("SELECT p from Preferences p WHERE p.userId = ?1 and p.type='sources'")
    Optional<Preferences> getSourcesPreferencesByUserId(Long userId);

    @Query("SELECT p from Preferences p WHERE p.userId = ?1 and p.type='countries'")
    Optional<Preferences> getCountriesPreferencesByUserId(Long userId);
}
