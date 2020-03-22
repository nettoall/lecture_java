package com.nettoall.net.chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.Socket;

public class ChatClient implements  Runnable, WindowListener, ActionListener {
    protected String host;
    protected int port;
    protected Frame frame;
    protected TextArea output;
    protected TextField input;

    protected DataInputStream dataIn;
    protected DataOutputStream dataOut;
    protected Thread listener;


    public ChatClient(String host, int port){
        this.host = host;
        this.port = port;

        frame = new Frame("ChatClient[" + host+ ':'+port+"]");
        frame.addWindowListener(this);
        output = new TextArea();
        output.setEditable(false);
        input = new TextField();
        input.addActionListener(this);
        frame.add("Center", output);
        frame.add("South", input);
        frame.pack();
    }

    public synchronized void start() throws IOException{
        if(listener == null){
            Socket socket = new Socket(host,port);
            try{
                dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            }catch(IOException ex){
                socket.close();
                throw ex;
            }
            listener = new Thread(this);
            listener.start();
            frame.setVisible(true);
        }
    }

    public synchronized void stop()  throws IOException{
        frame.setVisible(false);
        if(listener != null){
            listener.interrupt();
            listener = null;
            dataOut.close();
        }
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
                String line = dataIn.readUTF();
                output.append(line+"\n");
            }
        }catch(IOException ex){
            handleIOException(ex);
        }
    }

    protected synchronized void handleIOException(IOException ex){
        if(listener != null){
            output.append(ex + "\n");
            input.setVisible(false);
            frame.validate();

            if(listener != Thread.currentThread())
                listener.interrupt();
                listener = null;
                try{
                    dataOut.close();

                }catch(IOException ignored){

                }
        }
    }

    public void windowOpened(WindowEvent event){
        input.requestFocus();
    }

    public void windowClosing(WindowEvent event){
        try{
            stop();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void windowClosed(WindowEvent event){}
    public void windowIconified(WindowEvent event){}
    public void windowDeiconified(WindowEvent event){}
    public void windowActivated(WindowEvent event){}

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
//    pubilc void windowDeactivated(WindowEvent event){}

    public void actionPerformed(ActionEvent event){
        try{
            input.selectAll();
            dataOut.writeUTF(event.getActionCommand());
        }catch(IOException ex){
            handleIOException(ex);
        }
    }

    public static void main(String[] args) throws IOException{
        if((args.length != 1) || (args[0].indexOf(":") < 0))
            throw new IllegalArgumentException("Syntax: ChatClient <host>:<port>");

        int idx = args[0].indexOf(":");
        String host = args[0].substring(0, idx);
        int port = Integer.parseInt(args[0].substring(idx+1));

        ChatClient client = new ChatClient(host,port);
        client .start();

    }

}
