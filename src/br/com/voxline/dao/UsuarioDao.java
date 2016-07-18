package br.com.voxline.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.voxline.model.Usuario;

public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = -8489673368027731419L;
	
	@Inject
	private Session session;

	public void saveUsuario(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		session.save(usuario);
		tx.commit();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> getAll(){
		return session.createCriteria(Usuario.class).list();
	}
	public void delete(Usuario usuario){
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
	}
	
	public void alter(Usuario usuario){
		Transaction tx = session.beginTransaction();
		session.merge(usuario);
		tx.commit();
	}
}
