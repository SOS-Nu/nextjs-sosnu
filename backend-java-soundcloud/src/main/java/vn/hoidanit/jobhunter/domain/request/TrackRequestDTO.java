package vn.hoidanit.jobhunter.domain.request;

import lombok.Data;

@Data
public class TrackRequestDTO {
    private String category;
    private int limit;
}