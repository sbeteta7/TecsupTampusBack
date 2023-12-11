package com.tampusdev.tampus.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "favoritos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoritosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_favorito;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_anuncio")
    private Anuncio id_anuncio;
    private boolean estado_favorito;
    private LocalDate fecha_creacion;
}