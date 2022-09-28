package com.hepta.funcionarios.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

class FuncionarioServiceTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
		
	@Test
	void testFuncionarioRead() {
		FuncionarioService service = new FuncionarioService();
		try {
			service.FuncionarioRead();
		} catch (Exception e) {
			fail (e.toString());
		}
	}

	@Test
	void testFuncionarioCreate() {
		FuncionarioService service = new FuncionarioService();
		Funcionario func = new Funcionario();
		Setor s = new Setor();
		s.setId(1000);
		s.setNome("test");
		
		func.setId(100);
		func.setNome("Dayane");
		func.setSalario((double)3000);
		func.setEmail("day@feitoza.com");
		func.setSetor(s);
		
		try {		
			service.FuncionarioCreate(func);
		} catch (Exception e) {
			fail (e.toString());
		}
	}

	@Test
	void testFuncionarioUpdate() {
		FuncionarioService service = new FuncionarioService();
		Funcionario func = new Funcionario();
		Setor s = new Setor();
		s.setId(1000);
		s.setNome("test2");
		
		func.setId(100);
		func.setNome("Cristine");
		func.setSalario((double)3000);
		func.setEmail("cris@sousa.com");
		func.setSetor(s);
		
		try {		
			service.FuncionarioUpdate(100, func);
		} catch (Exception e) {
			fail(e.toString());
		}
		
	}

	@Test
	void testFuncionarioDelete() {
		FuncionarioService service = new FuncionarioService();
		Funcionario func = new Funcionario();
		Setor s = new Setor();
		s.setId(1000);
		s.setNome("test");
		
		func.setId(100);
		func.setNome("Day");
		func.setSalario((double)3000);
		func.setEmail("d@feitoza.com");
		func.setSetor(s);
		
		try {
			service.FuncionarioDelete(100);
		} catch (Exception e) {
			fail (e.toString());
		}
		
	}

}