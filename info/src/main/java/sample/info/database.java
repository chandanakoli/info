package sample.info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new customer("chandana", "eluru")));
      log.info("Preloading " + repository.save(new customer("sunny", "Mysore")));
      log.info("Preloading " + repository.save(new customer("smily", "vjd")));
      log.info("Preloading " + repository.save(new customer("Ram", "hyd")));
    };
  }
}

