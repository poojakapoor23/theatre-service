package com.pooja.service.impl;

import com.pooja.model.Theatre;
import com.pooja.repository.TheatreRepository;
import com.pooja.service.TheatreService;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository repo ;

    public TheatreServiceImpl(TheatreRepository repo) {
        this.repo = repo;
    }

    @Override
    public Theatre saveTheatre(Theatre theatre) {
        repo.save(convertModel2Entity(theatre));
        return theatre;
    }

    private static com.pooja.entity.Theatre convertModel2Entity(Theatre theatreModel) {
        com.pooja.entity.Theatre theatreEntity = new com.pooja.entity.Theatre();
        theatreEntity.setId(theatreModel.getId());
        theatreEntity.setName(theatreModel.getName());
        theatreEntity.setLocation(theatreModel.getLocation());
        theatreEntity.setCity( theatreModel.getCity());
        theatreEntity.setSeating_capacity(theatreModel.getSeating_capacity());
        return theatreEntity;
    }

    @Override
    public Optional<Theatre> getTheatreById(String id) {
        Optional<com.pooja.entity.Theatre> theatreEntity = repo.findById(id);
        Theatre theatreModel = new Theatre();
        convertEntity2Model(theatreModel, theatreEntity.orElse(null));

        return Optional.of(theatreModel);
    }
    private static void convertEntity2Model(Theatre theatreModel, com.pooja.entity.Theatre theatreEntity) {
        if (theatreEntity != null) {

            theatreModel.setId(theatreEntity.getId());
            theatreModel.setName(theatreEntity.getName());
            theatreModel.setLocation(theatreEntity.getLocation());
            theatreModel.setCity(theatreEntity.getCity());
            theatreModel.setSeating_capacity(theatreEntity.getSeating_capacity());

        }
    }
    @Override
    public List<Theatre> getAllTheatres() {
        return List.of();
    }

    @Override
    public Theatre updateTheatre(String id, Theatre theatre) {
//        theatre = repo.findById(id);
//        com.pooja.entity.Theatre theatreEntity = convertModel2Entity(theatre);

        if(repo.existsById(id)){
            repo.save(convertModel2Entity(theatre));
            return theatre;
        }
    return null;
    }
    @Override
    public void deleteTheatre(String id) {
        repo.deleteById(id);
    }

}
