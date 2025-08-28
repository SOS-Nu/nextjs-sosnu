package vn.hoidanit.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.jobhunter.domain.Track;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, String> {
    List<Track> findByCategoryAndIsDeletedFalse(String category, org.springframework.data.domain.Pageable pageable);
}