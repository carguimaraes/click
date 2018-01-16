package gma.click.domain.service;

public interface ISendTransacao {
	
	public boolean executar(TransacaoMensagem msg) throws Exception;

}
