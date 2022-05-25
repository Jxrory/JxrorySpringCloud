package com.jxrory.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Rory
 * @since 2022-04-18
 */
@SpringBootApplication
@ComponentScan({"com.jxrory"})
public class OssServer {

    public static void main(String[] args) {
        SpringApplication.run(OssServer.class, args);
    }

}
