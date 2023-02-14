package com.agana.gestiondestock.services.impl;

import com.agana.gestiondestock.dto.ArticleDto;
import com.agana.gestiondestock.dto.MvtStkDto;
import com.agana.gestiondestock.exception.ErrorCodes;
import com.agana.gestiondestock.exception.InvalidEntityException;
import com.agana.gestiondestock.model.TypeMvtStk;
import com.agana.gestiondestock.repository.ArticleRepository;
import com.agana.gestiondestock.repository.MvtStkRepository;
import com.agana.gestiondestock.services.MvtStkService;
import com.agana.gestiondestock.validator.MvtStkDValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository mvtStkRepository;
    private ArticleRepository articleRepository;
    @Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository, ArticleRepository articleRepository){
        this.mvtStkRepository = mvtStkRepository;
        this.articleRepository = articleRepository;
    };

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if (idArticle == null){
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleRepository.findById(idArticle);
        return mvtStkRepository.stockReelArticle(idArticle);
    }

    @Override
    public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
        if (idArticle == null){
            log.warn("ID article is NULL");
            return null;
        }
        return  mvtStkRepository.findAllByArticleId(idArticle).stream().map(MvtStkDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public MvtStkDto entreeStock(MvtStkDto mvtStkDto) {

        return entreePositive(mvtStkDto, TypeMvtStk.ENTREE);
    }

    @Override
    public MvtStkDto sortieStock(MvtStkDto mvtStkDto) {
        return sortieNegative(mvtStkDto, TypeMvtStk.SORTIE);
    }

    @Override
    public MvtStkDto correctionStockPos(MvtStkDto mvtStkDto) {
        return entreePositive(mvtStkDto, TypeMvtStk.CORRECTION_POS);
    }

    @Override
    public MvtStkDto correctionStockNeg(MvtStkDto mvtStkDto) {
        return sortieNegative(mvtStkDto, TypeMvtStk.CORRECTION_NEG);
    }



    private MvtStkDto entreePositive(MvtStkDto mvtStkDto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStkDValidator.validate(mvtStkDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", mvtStkDto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        mvtStkDto.setQuantity(
                BigDecimal.valueOf(
                        Math.abs(mvtStkDto.getQuantity().doubleValue())
                )
        );
        mvtStkDto.setTypeMvt(typeMvtStk);
        return MvtStkDto.fromEntity(
                mvtStkRepository.save(MvtStkDto.toEntity(mvtStkDto))
        );
    }

    private MvtStkDto sortieNegative(MvtStkDto mvtStkDto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStkDValidator.validate(mvtStkDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", mvtStkDto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        mvtStkDto.setQuantity(
                BigDecimal.valueOf(
                        Math.abs(mvtStkDto.getQuantity().doubleValue()) * -1
                )
        );
        mvtStkDto.setTypeMvt(typeMvtStk);
        return MvtStkDto.fromEntity(
                mvtStkRepository.save(MvtStkDto.toEntity(mvtStkDto))
        );
    }
}
