package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {
    private Integer id;
    private String code;

    private Instant dateventes;

    private String remark;
    private List<LigneVenteDto> ligneVentes;
    private Integer idEntreprise;

    public static VentesDto fromEntity(Ventes ventes) {
        if (ventes == null){
            return null;

            // TODO throw and exception
        }
        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateventes(ventes.getDateventes())
                .remark(ventes.getRemark())
                .idEntreprise(ventes.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDto ventesDto) {
        if (ventesDto == null){
            return null;

            // TODO throw and exception
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDateventes(ventesDto.getDateventes());
        ventes.setRemark(ventesDto.getRemark());
        ventes.setIdEntreprise(ventesDto.getIdEntreprise());
        return ventes;
    }
}
