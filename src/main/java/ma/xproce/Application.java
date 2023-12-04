package ma.xproce;

import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import ma.xproce.repositories.CreatorRepository;
import ma.xproce.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@SpringBootApplication
public class Application {
	@Autowired
	private CreatorRepository creatorRepository;
	@Autowired
	private VideoRepository videoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@MutationMapping
	public Creator saveCreator(@Argument Creator creator) { return creatorRepository.save(creator) ;}

	@MutationMapping
	public Video saveVideo(@Argument Video video) { return videoRepository.save(video) ;}

}
