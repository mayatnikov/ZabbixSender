package mvn.test;

import io.github.hengyunabc.zabbix.sender.DataObject;
import io.github.hengyunabc.zabbix.sender.SenderResult;
import io.github.hengyunabc.zabbix.sender.ZabbixSender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

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
        dataObject.setKey("key1");
        dataObject.setValue("aaaabbbcccddd:1234567890");
        // TimeUnit is SECONDS.
        dataObject.setClock(System.currentTimeMillis()/1000);
        SenderResult result = null;
        try {
            result = zabbixSender.send(dataObject);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("result:" + result);
        if (result.success()) {
            System.out.println("send success.");
        } else {
            System.err.println("send fail!");
        }


        Assert.assertEquals("","");

    }
}