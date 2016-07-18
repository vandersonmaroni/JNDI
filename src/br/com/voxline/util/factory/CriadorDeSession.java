package br.com.voxline.util.factory;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class CriadorDeSession implements Serializable {
	private static final long serialVersionUID = 733342614381933479L;
	
	/**
	 * Deixa o <b>CDI</b> responsável para criar a session
	 * @return uma <b>session</b>
	 */
	@Produces @RequestScoped
	public Session getSession() {
		Session session = getSessionFactory().openSession();
		return session;
	}
	
	/**
	 * Cria uma <b>session factory</b>
	 * @return uma <b>session factory</b>
	 */
	public SessionFactory getSessionFactory() {
		  Configuration conf = new Configuration();
		  conf.configure();
		  ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();        
		  return conf.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * Deixa o CDI responsável para finalizar a session
	 * @param session
	 */
	public void endSession(@Disposes Session session){
		session.close();
	}
}
