package ma.xproce.web;

import ma.xproce.entities.Creator;
import ma.xproce.entities.Video;
import ma.xproce.repositories.CreatorRepository;
import ma.xproce.repositories.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQIController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;

    VideoGraphQIController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> videosList() { return videoRepository.findAll();}

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id).orElseThrow(()  -> new RuntimeException(String.format("Creator %s not found", id) ));
    }

}
