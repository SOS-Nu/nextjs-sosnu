package vn.hoidanit.jobhunter.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Uploader {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;

    private String email;
    private String name;
    private String role;
    private String type;
}