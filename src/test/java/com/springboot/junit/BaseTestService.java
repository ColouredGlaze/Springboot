package com.springboot.junit;

import com.springboot.Springboot;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Springboot.class})
public class BaseTestService {
}
