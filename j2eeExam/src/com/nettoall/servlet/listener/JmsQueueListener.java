package com.nettoall.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JmsQueueListener implements ServletContextListener {
   public void contextInitialized(ServletContextEvent sce ) throws RuntimeException{
       ServletContext contex = sce.getServletContext();
       System.out.println("##### JmsQueueListener initialized #######");
   }

   public void contextDestroyed(ServletContextEvent sce ) {
       System.out.println("##### JmsQueueListener destroyed... #####");
   }

}
