package com.nettoall.jms.topic;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class ChatTopic implements MessageListener {
    private TopicSession pubSession;
    private TopicSession subSesion;
    private TopicPublisher publisher;
    private TopicConnection connection;
    private String username;

    public ChatTopic(String topicName, String username, String password) throws Exception{
        //JNDI 연결을 얻는다.
        Properties env = new Properties();

        //벤더에 종속적인 속성들을 설정
        InitialContext jndi = new InitialContext();
        //JMS 연결을 생성해주는 팩토리를 찾는다.
        TopicConnectionFactory conFactory = (TopicConnectionFactory)jndi.lookup("jms/tesetFactory");

        //JMS연결을 생성한다.
        TopicConnection connection = conFactory.createTopicConnection(username,password );

        //두개의 JMS세션 객체들을 생성
        TopicSession pubSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        TopicSession subSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        //JMS 토픽을 찾는다.
        Topic chatTopic = (Topic)jndi.lookup(topicName);

        //JMS 발생자와 구독자를 만든다.
        TopicPublisher publisher = pubSession.createPublisher(chatTopic);
        TopicSubscriber subscriber = subSession.createSubscriber(chatTopic);

        //JMM 메시지 리스너를 설정
        subscriber.setMessageListener(this);

        // 채팅 애플리케이션을 초기화
        set(connection, pubSession, subSession,publisher,username);

        //JMS연결을 시작하고 메시지가 배달되도록 한다.
        connection.start();
    }

    // 인스턴스 변수 초기화
    public void set(TopicConnection con, TopicSession pubSession, TopicSession subSesion, TopicPublisher pub, String username){
       this.connection = con;
       this.pubSession = pubSession;
       this.subSesion = subSesion;
       this.publisher = pub;
       this.username = username;
    }

    // 토픽 구독자로부터 메시지를 받는다.
    public void onMessage(Message message){
        try{
            TextMessage textMessage = (TextMessage)message;
            String text = textMessage.getText();
            System.out.println(text);
        }catch(JMSException jmse){
            jmse.printStackTrace();
        }
    }

    //토픽 발행자를 사용하여 메시지를 생성하고 전송
    protected void writeMessage(String text) throws JMSException{
        TextMessage message = pubSession.createTextMessage();
        message.setText(username + " : " + text);
        publisher.publish(message);
    }

    //JMS연결을 닫는다.
    public void close() throws JMSException{
        connection.close();
    }

    //Chat클라이언트를 실행
    public static void main(String[] args){
        try{
            if(args.length != 3)
                System.out.println("Topic or username missing");

            //args[0] = topicNamel args[1] = usernmae; args[2]=password
            ChatTopic chat = new ChatTopic(args[0], args[1], args[2]);

            //명령행에서 입력을 받는다.
            BufferedReader commandLine = new BufferedReader(new InputStreamReader(System.in));

            // 'exit' 가 입력될때가지 루프
            while(true){
                String s = commandLine.readLine();
                if(s.equalsIgnoreCase("exit")){
                    chat.close();
                    System.exit(0);
                }else{
                    chat.writeMessage(s);
                }
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

}
