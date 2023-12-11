package com.tampusdev.tampus.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@Entity
@Table(name = "anuncio_files")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_anuncio")
    private Anuncio id_anuncio;

    @ManyToOne
    @JoinColumn(name = "id_file")
    private FileDetails id_file;
}
