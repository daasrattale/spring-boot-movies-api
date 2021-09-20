package io.xrio.movies.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 20/9/2021
 */
public abstract class AbstractConverter <DM, DTO> {

    public abstract DM convertToDM(DTO dto);

    public abstract DTO convertToDTO(DM dm);

    public List<DM> convertToDMs(List<DTO> dtos) {
        List<DM> dms = new ArrayList<>();
        for (DTO dto : dtos) dms.add(convertToDM(dto));
        return dms;
    }

    public List<DTO> convertToDTOs(List<DM> dms) {
        List<DTO> dtos = new ArrayList<>();
        for (DM dm : dms) dtos.add(convertToDTO(dm));
        return dtos;
    }

}
