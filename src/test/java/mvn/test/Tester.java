package mvn.test;

import io.github.hengyunabc.zabbix.sender.DataObject;
import io.github.hengyunabc.zabbix.sender.SenderResult;
import io.github.hengyunabc.zabbix.sender.ZabbixSender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 16/07/16
 * Time: 23:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class Tester {

    @Test
    public void echoTest()  {
        String host = "192.168.17.220";
        int port = 10051;
        ZabbixSender zabbixSender = new ZabbixSender(host, port);
        DataObject dataObject = new DataObject();
        dataObject.setHost("macbookPro");
        dataObject.setKey("testItem-1");
        // TimeUnit is SECONDS.
        dataObject.setClock(System.currentTimeMillis()/1000);
        SenderResult result = null;
        Random randomGenerator = new Random();
        try {

            //note a single Random object is reused here
            for (int idx = 1; idx <= 10; ++idx){
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



        Assert.assertEquals("","");

    }
}