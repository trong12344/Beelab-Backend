package com.Beelab.dto;

public class CommentDTO {
    private Integer id;
    private Integer productId;
    private Integer userId;
    private Integer content;
    private Integer ratedStar;
    private Integer status;
    private String imageUrl;
    private Integer ratedStart;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContent() {
        return this.content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getRatedStar() {
        return this.ratedStar;
    }

    public void setRatedStar(Integer ratedStar) {
        this.ratedStar = ratedStar;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getRatedStart() {
        return this.ratedStart;
    }

    public void setRatedStart(Integer ratedStart) {
        this.ratedStart = ratedStart;
    }
}
