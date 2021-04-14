package co.com.sofka.cargame.mapper.gameconfig;

import co.com.sofka.cargame.dto.gameconfig.TrackDTO;
import co.com.sofka.cargame.entity.Track;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrackMapper {



    public static Track toTrack(TrackDTO trackDTO) {
        if (trackDTO == null) {
            return null;
        }
        Track track = new Track();
        track.setId(trackDTO.getId());
        track.setName(trackDTO.getName());
        track.setKms(trackDTO.getKms());
        return track;
    }


    public static TrackDTO toTrackDTO(Track track) {
        if (track == null) {
            return null;
        }
        TrackDTO trackDTO = new TrackDTO();
        trackDTO.setId(track.getId());
        trackDTO.setName(track.getName());
        trackDTO.setKms(track.getKms());
        return trackDTO;
    }

    public static List<TrackDTO> toTrackDTOs(List<Track> tracks){
        if (tracks == null) {
            return null;
        }
        List<TrackDTO> list = new ArrayList(tracks.size());
        Iterator listTracks = tracks.iterator();

        while(listTracks.hasNext()) {
            Track track = (Track)listTracks.next();
            list.add(TrackMapper.toTrackDTO(track));
        }

        return list;
    }
}
