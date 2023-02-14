package com.agana.gestiondestock.services;

import com.agana.gestiondestock.dto.MvtStkDto;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStkService {
    BigDecimal stockReelArticle(Integer idArticle);

    List<MvtStkDto> mvtStkArticle(Integer idArticle);

    MvtStkDto entreeStock(MvtStkDto dto);

    MvtStkDto sortieStock(MvtStkDto dto);

    MvtStkDto correctionStockPos(MvtStkDto dto);

    MvtStkDto correctionStockNeg(MvtStkDto dto);
}
