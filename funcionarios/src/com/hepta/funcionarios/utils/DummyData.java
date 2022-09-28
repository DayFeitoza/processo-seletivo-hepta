package com.hepta.funcionarios.utils;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;

public class DummyData {

	public static void main(String ... args) throws Exception {
		FuncionarioDAO dao = new FuncionarioDAO();
		Setor s = new Setor();
		//s.setId(1);
		s.setNome("Dev Java Jr");
		
		Funcionario f = new Funcionario();
		//f.setId(1);
		f.setEmail("day@feitoza.com");
		f.setIdade(30);
		f.setNome("Dayane");
		f.setSalario(3000.00);
		f.setSetor(s);
		
		dao.save(f);
	}
	 

}