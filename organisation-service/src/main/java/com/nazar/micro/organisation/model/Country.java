package com.nazar.micro.organisation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Country {

    @Id
    private Long id;

    @Column
    private String countySimpleName;

    @Column
    private long population;

    @Column
    private String capital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Organisation organisation;
}