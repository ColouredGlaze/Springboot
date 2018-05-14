package org.springboot.addScan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：
 */
@Configuration
public class ScanCommandLineRunner implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>ScanCommandLineRunner<<<<<<<<<");
    }
}
