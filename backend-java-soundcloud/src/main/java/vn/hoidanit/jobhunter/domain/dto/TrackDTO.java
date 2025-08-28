package vn.hoidanit.jobhunter.domain.dto;

import lombok.Data;

@Data
public class TrackDTO {
    private String _id;
    private String title;
    private String description;
    private String category;
    private String imgUrl;
    private String trackUrl;
    private int countLike;
    private int countPlay;
    private UploaderDTO uploader;
    private boolean isDeleted;
    private String createdAt;
    private String updatedAt;
}