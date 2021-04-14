package co.com.sofka.cargame.service;

import co.com.sofka.cargame.dto.TrackDTO;
import co.com.sofka.cargame.entity.Track;
import co.com.sofka.cargame.mapper.TrackMapper;
import co.com.sofka.cargame.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameConfigService {

    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    private TrackMapper trackMapper;


    public TrackDTO saveTrack(TrackDTO trackDTO){
        Track track = trackMapper.toTrack(trackDTO);
        return trackMapper.toTrackDTO(trackRepository.save(track));
    }

    public List<TrackDTO> findAll() {
        List<Track> trackList = (List<Track>) trackRepository.findAll();
        return trackMapper.toTrackDTOs(trackList);
    }
}
