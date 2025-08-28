package vn.hoidanit.jobhunter.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;

    private String title;
    private String description;
    private String category;
    private String imgUrl;
    private String trackUrl;
    private int countLike;
    private int countPlay;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private Uploader uploader;

    private boolean isDeleted;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}