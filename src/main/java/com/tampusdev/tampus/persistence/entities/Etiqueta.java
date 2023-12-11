package com.tampusdev.tampus.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_etiqueta;

    @Column(length = 50)
    private String nombre;
}
