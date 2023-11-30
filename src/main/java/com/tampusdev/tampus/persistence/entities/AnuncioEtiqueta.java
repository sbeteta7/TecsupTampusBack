package com.tampusdev.tampus.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Entity
@Table(name = "AnuncioEtiqueta")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioEtiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_anuncio")
    private Anuncio id_anuncio;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Etiqueta id_etiqueta;

}
