package vn.hoidanit.jobhunter.controller;

import lombok.RequiredArgsConstructor;
import vn.hoidanit.jobhunter.domain.dto.TrackDTO;
import vn.hoidanit.jobhunter.domain.request.TrackRequestDTO;
import vn.hoidanit.jobhunter.domain.response.BackendResDTO;
import vn.hoidanit.jobhunter.service.TrackService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    @PostMapping("/top")
    public ResponseEntity<BackendResDTO<List<TrackDTO>>> getTopTracks(@RequestBody TrackRequestDTO request) {
        List<TrackDTO> tracks = trackService.getTopTracks(request);
        BackendResDTO<List<TrackDTO>> response = new BackendResDTO<>();
        response.setMessage("Success");
        response.setStatusCode("200");
        response.setData(tracks);
        return ResponseEntity.ok(response);
    }

    // Endpoint GET mới
    @GetMapping("/top")
    public ResponseEntity<BackendResDTO<List<TrackDTO>>> getTopTracksByQuery(
            @RequestParam("category") String category,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        TrackRequestDTO request = new TrackRequestDTO();
        request.setCategory(category);
        request.setLimit(limit);

        List<TrackDTO> tracks = trackService.getTopTracks(request);
        BackendResDTO<List<TrackDTO>> response = new BackendResDTO<>();
        response.setMessage("Success");
        response.setStatusCode("200");
        response.setData(tracks);
        return ResponseEntity.ok(response);
    }
}