package com.example.studentperformancemanagement.Helper;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.Interface.IGetTeaCourse;
import com.example.studentperformancemanagement.Interface.IQueryCourse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/*
* 得到教师授课列表
* */
public class GetTeaCourseNetWorkHelper {
    private static final int HANDLER_MSG_TELL_RECV = 1;

    private IGetTeaCourse callback;

    private Fragment mContent;

    public GetTeaCourseNetWorkHelper(Fragment appCompatActivity) {
        this.mContent = appCompatActivity;
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            callback.onSucceed(msg.obj.toString());
        }
    };

    public void setCallback(IGetTeaCourse callback) {
        this.callback = callback;
    }

    public void startNetThread(final String host, final int port, final String data) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //创建客户端对象
                    Socket socket = new Socket(host, port);
                    //获取客户端对象的输出流
                    OutputStream outputStream = socket.getOutputStream();
                    //把内容以字节的形式写入（data）.getBytes()
                    outputStream.write(data.getBytes());
                    //刷新管道流
                    outputStream.flush();
                    //拿到客户端输入流
                    InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[2048];
                    //回应数据
                    int n = is.read(bytes);
                    Message msg = handler.obtainMessage(HANDLER_MSG_TELL_RECV, new String(bytes, 0, n));
                    msg.sendToTarget();
                    is.close();
                    socket.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
