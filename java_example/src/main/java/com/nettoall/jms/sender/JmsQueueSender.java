package com.nettoall.jms.sender;

//import org.apache.logging.log4j.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class JmsQueueSender {
    //static Logger log;
    QueueConnection conn;
    QueueSession session;
    Queue queue;
    public static void main(String[] args) throws Exception{
        System.out.println("JmsQueueSender");
        System.out.println("Begin SendClisne, now = " + System.currentTimeMillis());
        JmsQueueSender sender = new JmsQueueSender();

        sender.init();
        sender.send("A text msg");
        sender.stop();
        System.out.println("End Send...");
        System.exit(0);
    }

    public void init() throws JMSException, NamingException{
        Properties env = new Properties();
        env.put(Context.PROVIDER_URL,"http-remoting://192.168.0.2:8080");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL,"tester");
        env.put(Context.SECURITY_CREDENTIALS,"test1234");

        InitialContext ctx = new InitialContext(env);
        Object tmp = ctx.lookup("jms/RemoteConnectionFactory");
        System.out.println("lookup RemoteConnectionFactory.............");
        QueueConnectionFactory qcf = (QueueConnectionFactory)tmp;
        conn = qcf.createQueueConnection();
        queue = (Queue)ctx.lookup("jms/queue/test");
        System.out.println("lookup queue.............");
        session = conn.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
        conn.start();

    }

    public void send(String text) throws JMSException,NamingException{
        System.out.println("Begin Send");
        QueueSender send = session.createSender(queue);
        TextMessage tm = session.createTextMessage(text);
        System.out.println("send : " + text);
        send.send(tm);
        send.close();
    }

    public void stop() throws JMSException{
        conn.stop();
        session.close();
        conn.close();
    }
}
