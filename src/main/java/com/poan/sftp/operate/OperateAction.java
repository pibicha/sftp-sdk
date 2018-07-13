package com.poan.sftp.operate;

import com.jcraft.jsch.ChannelSftp;

/**
 * @Author: panbenxing
 * @Date: 2018/7/10
 * @Description:
 */
public interface OperateAction {

    void doInConnection(ChannelSftp chSftp, ProgressMonitor monitor, String src, String dst);
}
