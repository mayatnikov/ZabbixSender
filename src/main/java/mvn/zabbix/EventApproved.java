package mvn.zabbix;

import io.github.hengyunabc.zabbix.sender.DataObject;
import io.github.hengyunabc.zabbix.sender.SenderResult;
import io.github.hengyunabc.zabbix.sender.ZabbixSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 19/03/17
 * Time: 16:18
 */
@Component
public class EventApproved {

@Autowired
    ZabbixConfig zbx;

@PostConstruct
    public void init() {
    ZabbixSender zabbixSender = new ZabbixSender(zbx.getHost(),zbx.getPort());
    DataObject dataObject = new DataObject();
    dataObject.setHost(zbx.getZabbixHost());
    dataObject.setKey("approved");
    dataObject.setClock(System.currentTimeMillis()/1000);
    System.out.println("ZabbixHost:"+zbx.getZabbixHost());
    System.out.println(dataObject);
    SenderResult result = null;
    Random randomGenerator = new Random();
    try {
        for (int idx = 1; idx <= 30; ++idx){
            Integer randomInt = randomGenerator.nextInt(100);
            dataObject.setValue(randomInt.toString());
            result = zabbixSender.send(dataObject);
            System.out.println("result:" + result);
            if (result.success()) {
                System.out.println("send success.");
            } else {
                System.err.println("send fail!");
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

}

}
