package vn.hoidanit.jobhunter.service;

import lombok.RequiredArgsConstructor;
import vn.hoidanit.jobhunter.domain.Track;
import vn.hoidanit.jobhunter.domain.dto.TrackDTO;
import vn.hoidanit.jobhunter.domain.dto.UploaderDTO;
import vn.hoidanit.jobhunter.domain.request.TrackRequestDTO;
import vn.hoidanit.jobhunter.repository.TrackRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;

    public List<TrackDTO> getTopTracks(TrackRequestDTO request) {
        List<Track> tracks = trackRepository.findByCategoryAndIsDeletedFalse(
                request.getCategory(),
                PageRequest.of(0, request.getLimit()));

        return tracks.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TrackDTO convertToDTO(Track track) {
        TrackDTO dto = new TrackDTO();
        dto.set_id(track.get_id());
        dto.setTitle(track.getTitle());
        dto.setDescription(track.getDescription());
        dto.setCategory(track.getCategory());
        dto.setImgUrl(track.getImgUrl());
        dto.setTrackUrl(track.getTrackUrl());
        dto.setCountLike(track.getCountLike());
        dto.setCountPlay(track.getCountPlay());
        dto.setDeleted(track.isDeleted());
        dto.setCreatedAt(track.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        dto.setUpdatedAt(track.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        if (track.getUploader() != null) {
            UploaderDTO uploaderDTO = new UploaderDTO();
            uploaderDTO.set_id(track.getUploader().get_id());
            uploaderDTO.setEmail(track.getUploader().getEmail());
            uploaderDTO.setName(track.getUploader().getName());
            uploaderDTO.setRole(track.getUploader().getRole());
            uploaderDTO.setType(track.getUploader().getType());
            dto.setUploader(uploaderDTO);
        }

        return dto;
    }
}