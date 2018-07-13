package com.poan.sftp.config;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description: ChannelConfig构建器
 */
public class ChannelBuilder {

    private ChannelConfig channelConfig;

    public ChannelBuilder() {
        ChannelConfig channelConfig = new ChannelConfig();
        this.channelConfig = channelConfig;
    }

    public static ChannelBuilder of() {
        ChannelBuilder channelBuilder = new ChannelBuilder();
        return channelBuilder;
    }

    public ChannelBuilder setFtpHost(String host) {
        this.channelConfig.setHost(host);
        return this;
    }

    public ChannelBuilder setPort(Integer port) {
        this.channelConfig.setPort(port);
        return this;
    }

    public ChannelBuilder setUserName(String userName) {
        this.channelConfig.setUserName(userName);
        return this;
    }

    public ChannelBuilder setPassword(String password) {
        this.channelConfig.setPassword(password);
        return this;
    }

    public ChannelBuilder setTimeOut(Integer timeOut) {
        this.channelConfig.setTimeout(timeOut);
        return this;
    }

    public ChannelBuilder setIdentityFile(String identityFile) {
        this.channelConfig.setIdentityFile(identityFile);
        return this;
    }

    public ChannelConfig builder() {
        return this.channelConfig;
    }


}