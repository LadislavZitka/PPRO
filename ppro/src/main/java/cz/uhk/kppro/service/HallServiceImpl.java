package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Hall;
import cz.uhk.kppro.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {
    private HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElse(null);
    }

    @Override
    public Hall deleteHall(Long id) {
        Optional<Hall> hallOptional = hallRepository.findById(id);
        if (hallOptional.isPresent()) {
            Hall hall = hallOptional.get();
            hallRepository.delete(hallOptional.get());
            return hall;
        }
        return null;
    }

    @Override
    public boolean addHall(Hall hall) {
        hallRepository.save(hall);
        return true;
    }

    @Override
    public boolean updateHall(Hall hall) {
        Optional<Hall> hallOptional = hallRepository.findById(hall.getId());
        if (hallOptional.isPresent()) {
            hallRepository.save(hall);
            return true;
        }
        return false;
    }
}
