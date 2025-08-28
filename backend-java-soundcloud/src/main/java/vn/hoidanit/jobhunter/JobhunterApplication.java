package vn.hoidanit.jobhunter;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import vn.hoidanit.jobhunter.domain.Track;
import vn.hoidanit.jobhunter.domain.Uploader;
import vn.hoidanit.jobhunter.repository.TrackRepository;
import vn.hoidanit.jobhunter.repository.UploaderRepository;

//disable security
// @SpringBootApplication(exclude = {
// 		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
// 		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
// })

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching // Bật tính năng Caching của Spring
public class JobhunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobhunterApplication.class, args);
	}

	// Thêm dữ liệu mẫu
	@Bean
	CommandLineRunner initData(TrackRepository trackRepository, UploaderRepository uploaderRepository) {
		return args -> {
			Uploader uploader = new Uploader();
			uploader.setEmail("user@example.com");
			uploader.setName("Test User");
			uploader.setRole("USER");
			uploader.setType("LOCAL");
			uploaderRepository.save(uploader);

			Track track1 = new Track();
			track1.setTitle("Chill Song 1");
			track1.setDescription("A relaxing track");
			track1.setCategory("CHILL");
			track1.setImgUrl("http://example.com/img1.jpg");
			track1.setTrackUrl("http://example.com/track1.mp3");
			track1.setCountLike(100);
			track1.setCountPlay(500);
			track1.setUploader(uploader);
			track1.setDeleted(false);

			Track track2 = new Track();
			track2.setTitle("Workout Song 1");
			track2.setDescription("An energetic track");
			track2.setCategory("WORKOUT");
			track2.setImgUrl("http://example.com/img2.jpg");
			track2.setTrackUrl("http://example.com/track2.mp3");
			track2.setCountLike(200);
			track2.setCountPlay(1000);
			track2.setUploader(uploader);
			track2.setDeleted(false);

			Track track3 = new Track();
			track3.setTitle("Party Song 1");
			track3.setDescription("A party anthem");
			track3.setCategory("PARTY");
			track3.setImgUrl("http://example.com/img3.jpg");
			track3.setTrackUrl("http://example.com/track3.mp3");
			track3.setCountLike(150);
			track3.setCountPlay(700);
			track3.setUploader(uploader);
			track3.setDeleted(false);

			trackRepository.saveAll(List.of(track1, track2, track3));
		};

	}
}
