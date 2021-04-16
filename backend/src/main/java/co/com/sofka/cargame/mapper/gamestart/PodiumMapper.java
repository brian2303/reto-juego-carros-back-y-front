package co.com.sofka.cargame.mapper.gamestart;

import co.com.sofka.cargame.dto.gamestart.PodiumDTO;
import co.com.sofka.cargame.entity.Podium;

import java.util.ArrayList;
import java.util.List;

public class PodiumMapper {

    public static PodiumDTO toPodiumDTO(Podium podium){
        PodiumDTO podiumDTO = new PodiumDTO();
        podiumDTO.setName(podium.getName());
        podiumDTO.setWonTimes(podium.getWonTimes());
        return podiumDTO;
    }

    public static List<PodiumDTO> toListPodiumDTO(List<Podium> podiumList){
        List<PodiumDTO> podiumDTOList = new ArrayList();
        for (Podium podium: podiumList){
            podiumDTOList.add(toPodiumDTO(podium));
        }
        return podiumDTOList;
    }
}
