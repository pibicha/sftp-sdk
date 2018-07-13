package com.poan.sftp.factory;

import com.jcraft.jsch.*;
import com.poan.sftp.config.ChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description: 获取sftp连接； 如果有并发获取，不便于将连接设置为单例。
 */
public class SFTPChannelFactory {

    private Session session = null;
    private Channel channel = null;

    private static final Logger LOG = LoggerFactory.getLogger(SFTPChannelFactory.class.getName());

    public ChannelSftp getChannel(ChannelConfig channelConfig) throws JSchException {

        String ftpHost = channelConfig.getHost();
        Integer ftpPort = channelConfig.getPort();
        String ftpUserName = channelConfig.getUserName();
        String ftpPassword = channelConfig.getPassword();
        Integer timeout = channelConfig.getTimeout();
        String identityFile = channelConfig.getIdentityFile();

        JSch jsch = new JSch(); // 创建JSch对象
        jsch.addIdentity(identityFile);
        Session session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // 根据用户名，主机ip，端口获取一个Session对象
        LOG.debug("Session created.");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        LOG.debug("Session connected.");

        LOG.debug("Opening Channel.");
        Channel channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        LOG.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel() {
        if (session != null) {
            session.disconnect();
        }
        if (channel != null) {
            channel.disconnect();
        }
    }
}
