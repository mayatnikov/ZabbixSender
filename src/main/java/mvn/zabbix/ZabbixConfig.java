package mvn.zabbix;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 19/03/17
 * Time: 16:19
 */
@Component
@ConfigurationProperties(prefix="zabbix")
public class ZabbixConfig {
    String host;
    Integer port;
    String zabbixHost;

    public String getZabbixHost() {
        return zabbixHost;
    }

    public void setZabbixHost(String zabbixHost) {
        this.zabbixHost = zabbixHost;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
