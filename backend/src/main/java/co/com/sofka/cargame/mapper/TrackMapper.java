package co.com.sofka.cargame.mapper;


import co.com.sofka.cargame.dto.TrackDTO;
import co.com.sofka.cargame.entity.Track;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    TrackDTO toTrackDTO(Track track);
    List<TrackDTO> toTrackDTOs(List<Track> tracks);

    Track toTrack(TrackDTO trackDTO);

}
