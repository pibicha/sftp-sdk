package com.poan.sftp.config;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description: sftp连接配置类
 */
public class ChannelConfig {

    private String host;
    private Integer port;
    private String IdentityFile;
    private String userName;
    private String password;
    private Integer timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityFile() {
        return IdentityFile;
    }

    public void setIdentityFile(String identityFile) {
        IdentityFile = identityFile;
    }
}
