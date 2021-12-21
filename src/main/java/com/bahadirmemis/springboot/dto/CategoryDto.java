package com.bahadirmemis.springboot.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long breakdown;
    private Long upperCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Long breakdown) {
        this.breakdown = breakdown;
    }

    public Long getUpperCategoryId() {
        return upperCategoryId;
    }

    public void setUpperCategoryId(Long upperCategoryId) {
        this.upperCategoryId = upperCategoryId;
    }
}
