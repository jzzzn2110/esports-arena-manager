package com.esports.manager.ranking.models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Ranking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranking_id")
    private Long rankingId;

    @NotNull(message = "El torneo no puede ser nulo")
    @Column(name = "torneo_id", nullable = false)
    private Long torneoId;

    @NotNull(message = "el participante no puede ser nulo")
    @Column(name = "participante_id", nullable = false)
    private Long participanteId;

    @Column(nullable = false)
    private Integer puntos = 0;

    @Column(nullable = false)
    private Integer victorias = 0;

    @Column(nullable = false)
    private Integer derrotas = 0;

    @Column(nullable = false)
    private Integer diferencia = 0;

    @Column(nullable = false)
    private Integer posicion = 0;


}
