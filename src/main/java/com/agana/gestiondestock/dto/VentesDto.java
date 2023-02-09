package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Ventes;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VentesDto {
    private Integer id;
    private String code;

    private Instant dateventes;

    private String remark;

    private Integer idEntreprise;

    public VentesDto fromEntity(Ventes ventes) {
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

    public Ventes toEntity(VentesDto ventesDto) {
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
