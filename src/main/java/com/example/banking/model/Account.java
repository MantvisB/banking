package com.example.banking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Setter
    @Getter
    @Entity
    @Table(name = "ACCOUNT")
    public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "ID",unique=true, nullable = false)
        private Long id;

        @Column(name = "BALANCE")
        private Double balance;

        @OneToOne()
        @JoinColumn(name = "USER_ID")
        private User user;

    }
