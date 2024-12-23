package gfs.webp.pesme;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GfsPesmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GfsPesmeApplication.class, args);
    }

    @Bean
    ModelMapper mapper(){
        return new ModelMapper();
    }

}
