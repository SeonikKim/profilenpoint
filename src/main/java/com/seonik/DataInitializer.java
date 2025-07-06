package com.seonik;


import com.seonik.domain.UserInfo;
import com.seonik.repository.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserInfoRepository repository;

    public DataInitializer(UserInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new UserInfo("user1", "가가가"));
            repository.save(new UserInfo("user2", "나나나"));
            repository.save(new UserInfo("user3", "다다다"));
        }
    }
}