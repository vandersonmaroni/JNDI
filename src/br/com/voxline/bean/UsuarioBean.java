package br.com.voxline.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.mapping.Array;

import br.com.voxline.dao.UsuarioDao;
import br.com.voxline.model.Usuario;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 2110381258117269393L;

	@Inject
	private UsuarioDao dao;
	private List<Usuario> listaUsuario = new ArrayList<Usuario>();
	public void Adicionar() {
		listaUsuario = dao.getAll();
		for (Usuario usuario : listaUsuario) {
			System.out.println(usuario);
		}
	}
}
