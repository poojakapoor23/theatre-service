package com.pooja.service;


import com.pooja.model.Theatre;

import java.util.List;
import java.util.Optional;

public interface TheatreService {
    Theatre saveTheatre(Theatre theater);
    Optional<Theatre> getTheatreById(String id);
    List<Theatre> getAllTheatres();
    Theatre updateTheatre(String id, Theatre theater);
    void deleteTheatre(String id);
}

