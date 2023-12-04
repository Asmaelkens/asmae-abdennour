package ma.xproce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name ="creator_id")
    private Creator creator;
}
