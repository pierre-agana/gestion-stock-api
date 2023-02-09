package com.agana.gestiondestock.dto;
import com.agana.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
    private Integer id;
    private String roleName;

    private Integer idEntreprise;

    private UtilisateurDto utilisateur;

    public RolesDto fromEntity(Roles roles) {
        if (roles == null){
            return null;

            // TODO throw and exception
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null){
            return null;

            // TODO throw and exception
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        return roles;
    }
}
