package com.poan.sftp;

import com.poan.sftp.config.ChannelBuilder;
import com.poan.sftp.config.ChannelConfig;
import com.poan.sftp.operate.Operation;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ChannelConfig channelConfig = ChannelBuilder.of().setFtpHost("172.25.47.80")
                .setUserName("sftp")
                .setPort(22)
                .setTimeOut(60000)
                .setIdentityFile("/root/.ssh/id_rsa")// 本机服务器ssh私钥所在路径
                .setPassword("sftp@123").builder();

        String src = "D:\\history.log"; // 本地文件名
        String dst = "/upload"; // 目标文件名

        Operation operation = new Operation();

        // fixme: 上传和下载，要区分谁才是src、dst；

        // 上传：
        operation.upload(channelConfig, src, dst);
        // 下载：
//        operation.download(channelConfig, dst + "/history.log", "d:\\logs\\hhhhh.log");

        System.exit(0);
    }
}
