package cn.springboot.addXmlConfig;

import org.springframework.stereotype.Service;

/**
 * @author MingTie
 * CreateDate：2017/8/20
 * Description：springboot不会扫描到的类
 */
@Service
public class NoAutoScanService {

    public NoAutoScanService(){
        super();
        System.out.println(">>>>>>>>>cn.springboot.addXmlConfig.NoAutoScanService<<<<<<<<<");
    }
}
