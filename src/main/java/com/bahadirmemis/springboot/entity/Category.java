package com.bahadirmemis.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

    public Category(Long id, String name, Long breakdown, Category upperCategory) {
        this.id = id;
        this.name = name;
        this.breakdown = breakdown;
        this.upperCategory = upperCategory;
    }

    public Category() {
    }

    @SequenceGenerator(name = "generator", sequenceName = "CATEGORY_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "BREAKDOWN")
    private Long breakdown;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UPPER_CATEGORY")
    private Category upperCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String adi) {
        this.name = adi;
    }

    public Long getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Long kirilim) {
        this.breakdown = kirilim;
    }

    public Category getUpperCategory() {
        return upperCategory;
    }

    public void setUpperCategory(Category ustKategori) {
        this.upperCategory = ustKategori;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
