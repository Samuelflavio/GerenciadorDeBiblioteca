package registros;

import java.util.ArrayList;

import dados.Cliente;

public class Rcliente {
	
	private ArrayList<Cliente> rC;
	
	public Rcliente() {
		rC = new ArrayList<Cliente>();
	}
    public void addCliente(Cliente cliente) {
    	rC.add(cliente);
    }
    public Cliente getCliente(int indice) {
    	return rC.get(indice);
    }
    public void removeContato(Cliente cliente) {
    	rC.remove(cliente);
    }
    public void removeContato(int indice) {
    	rC.remove(indice);
    }
    public int size() {
    	return rC.size();
    }

}
