package com.ccc.parcauto.fournisseur.model.dto;
import com.ccc.parcauto.fournisseur.model.Fournisseurs;
import com.ccc.parcauto.type_fournisseur.model.dto.TypeFournisseurDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseursDto {
    private Long id;
    private String nomFournisseur;
    private String pays;
    private String situationGeo;
    private  String telephone;
    private String email;
    private String nomContact;
    private String telephoneContact;
    private String emailContact;
    private TypeFournisseurDto typeFournisseur;
    private boolean statut;

    public static FournisseursDto toDto(Fournisseurs fournisseurs)
    {
        return FournisseursDto.builder()
                .id(fournisseurs.getId())
                .nomFournisseur(fournisseurs.getNomFournisseur())
                .pays(fournisseurs.getPays())
                .situationGeo(fournisseurs.getSituationGeo())
                .telephone(fournisseurs.getTelephone())
                .email(fournisseurs.getEmail())
                .nomContact(fournisseurs.getNomContact())
                .telephoneContact(fournisseurs.getTelephoneContact())
                .emailContact(fournisseurs.getEmailContact())
                .statut(fournisseurs.isStatut())
                .typeFournisseur(TypeFournisseurDto.toDto(fournisseurs.getTypeFournisseur()))
                .build();
    }

    public static Fournisseurs toEntity(FournisseursDto fournisseursDto)
    {
        return Fournisseurs.builder()
                .id(fournisseursDto.getId())
                .nomFournisseur(fournisseursDto.getNomFournisseur())
                .pays(fournisseursDto.getPays())
                .situationGeo(fournisseursDto.getSituationGeo())
                .telephone(fournisseursDto.getTelephone())
                .email(fournisseursDto.getEmail())
                .nomContact(fournisseursDto.getNomContact())
                .telephoneContact(fournisseursDto.getTelephoneContact())
                .emailContact(fournisseursDto.getEmailContact())
                .statut(fournisseursDto.isStatut())
                .typeFournisseur(TypeFournisseurDto.toEntity(fournisseursDto.getTypeFournisseur()))
                .build();
    }
}
