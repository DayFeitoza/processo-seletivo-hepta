package com.hepta.funcionarios.persistence;

import java.util.List;

public interface InterfaceDAO<T> {

	abstract void save(T object) throws Exception;
	abstract T update(Integer id, T object) throws Exception;
	abstract void delete(Integer id) throws Exception;
	abstract T find(Integer id) throws Exception;
	abstract List<T> getAll() throws Exception;
}