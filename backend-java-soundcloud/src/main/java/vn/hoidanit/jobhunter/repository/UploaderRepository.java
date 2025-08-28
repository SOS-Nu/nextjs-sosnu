package vn.hoidanit.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.jobhunter.domain.Uploader;

public interface UploaderRepository extends JpaRepository<Uploader, String> {
}