package org.example;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
public class DataBaseAppTest {

    @Test
    public void contextLoads() {
    }
}
