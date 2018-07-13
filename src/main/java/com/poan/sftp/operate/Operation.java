package com.poan.sftp.operate;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.poan.sftp.config.ChannelConfig;
import com.poan.sftp.factory.SFTPChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description:
 */
public class Operation implements BaseOperation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private void execute(OperateAction action, ChannelConfig config, String src, String dst) {
        SFTPChannelFactory channel = new SFTPChannelFactory();
        ChannelSftp chSftp = null;
        try {
            chSftp = channel.getChannel(config);
            ProgressMonitor monitor = new ProgressMonitor();
            // ====>>      打开sftp连接，关闭连接都是重复操作；将连接时的操作抽象出来。
            action.doInConnection(chSftp, monitor, src, dst);
            // 打开sftp连接，关闭连接都是重复操作；将连接时的操作抽象出来。    <<====
        } catch (Exception e) {
            logger.error("Error : {}", e);
        } finally {
            if (chSftp != null) {
                chSftp.quit();
            }
            channel.closeChannel();
        }
    }

    @Override
    public void upload(ChannelConfig config, String src, String dst) {
        execute(new OperateAction() {
            @Override
            public void doInConnection(ChannelSftp chSftp, ProgressMonitor monitor, String src, String dst) {
                try {
                    chSftp.put(src, dst, monitor, ChannelSftp.OVERWRITE);
                } catch (SftpException e) {
//                    e.printStackTrace();
                    logger.error("Error : {}", e);
                }
            }
        }, config, src, dst);
    }

    @Override
    public void download(ChannelConfig config, String src, String dst) {
        execute(new OperateAction() {
            @Override
            public void doInConnection(ChannelSftp chSftp, ProgressMonitor monitor, String src, String dst) {
                try {
                    chSftp.get(src,dst,monitor);
                } catch (SftpException e) {
//                    e.printStackTrace();
                    logger.error("Error : {}", e);
                }
            }
        }, config, src, dst);
    }
}
