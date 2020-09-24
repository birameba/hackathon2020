package com.htc.model;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by Birame Ba on 11/02/19.
 */
@Entity
@Table(name = "roles")
@ApiModel(description = "Tous les détails concernant le role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "la base de donnee va generer le ID du role")
    private Long id;
   
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    @ApiModelProperty(notes = "Enumérer le nom du role")
    private RoleName name;

    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}
