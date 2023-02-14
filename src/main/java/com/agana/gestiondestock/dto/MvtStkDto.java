package com.agana.gestiondestock.dto;

import com.agana.gestiondestock.model.Article;
import com.agana.gestiondestock.model.MvtStk;
import com.agana.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {
    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantity;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    private Integer idEntreprise;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null){
            return null;

            // TODO throw and exception
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantity(mvtStk.getQuantity())
                .typeMvt(mvtStk.getTypeMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {
        if (mvtStkDto == null){
            return null;

            // TODO throw and exception
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantity(mvtStkDto.getQuantity());
        mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
        mvtStk.setIdEntreprise(mvtStkDto.getIdEntreprise());
        return mvtStk;
    }
}
