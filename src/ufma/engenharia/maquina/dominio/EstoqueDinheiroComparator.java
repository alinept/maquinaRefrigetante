package ufma.engenharia.maquina.dominio;

import java.util.Comparator;

public class EstoqueDinheiroComparator implements Comparator<EstoqueDinheiro> {
    
	public int compare(EstoqueDinheiro e1, EstoqueDinheiro e2) {
        return e1.compareTo(e2);
    }
}
