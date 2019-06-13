package findhome;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
        //(exclude = {SecurityAutoConfiguration.class })/**/
public class FindhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindhomeApplication.class, args);
    }

    /**
     * Bean Util
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
