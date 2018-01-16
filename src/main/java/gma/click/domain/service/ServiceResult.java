package gma.click.domain.service;

import java.util.ArrayList;
import java.util.List;

//TODO este objeto pode ser melhorado para guardar uma lista de objetos MSG {codigo, descricao }
public class ServiceResult {
	
	private List<String> _listaMsg;
	
	public ServiceResult()
	{
		_listaMsg= new ArrayList<String>();
	}
	
	public void add(String msg) {
		
		_listaMsg.add(msg);
		
	}
	
	public boolean existeErro()
	{
		return !_listaMsg.isEmpty();
	}

	public List<String> getListaMsg()
	{
		
		return _listaMsg;
	}
	
	public boolean contemMsg(String msg)
	{
		
		return _listaMsg.contains(msg);
	}
}
