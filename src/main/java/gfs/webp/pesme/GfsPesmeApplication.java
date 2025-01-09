package gfs.webp.pesme;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import static gfs.webp.pesme.util.PrintUtils.*;

@SpringBootApplication
public class GfsPesmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GfsPesmeApplication.class, args);
    }

    @Bean
    ModelMapper mapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setPropertyCondition(context -> context.getSource() != null)
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }


    @EventListener(ApplicationReadyEvent.class)
    void start(){
        ispisiCeoRedJednaLinija();
        ispisiBanner();
        ispisiCeoRedJednaLinija();
        ispisiCeoRedDveLinije();
        ispisiUokvireno("COPYRIGHT - Gradjevinski Fakultet u Subotici, Univerzitet U Novom Sadu");
        ispisiCeoRedDveLinije();
        ispisiUokvireno("API URL: http://localhost:8080");
        ispisiUokvireno("Dokumentacija se nalazi na: http://localhost:8080/swagger-ui/index.html");
        ispisiCeoRedDveLinije();
    }

}
