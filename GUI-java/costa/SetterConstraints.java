import java.awt.*;
public class SetterConstraints{
	public GridBagConstraints setConstraints(int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight, int weightx, int weighty, int fill, int anchor, int i1, int i2, int i3, int i4){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = fill;	    //disposicao da componente
		c.anchor = anchor;  //fixa a componente em uma posicao	*por mim nao existiria
		c.gridx = gridx;    //celeciona a coluna da celula que a componente estara
		c.gridy = gridy;    //celeciona a linha da celula que a componente estara
		c.ipadx = ipadx;    //adiciona a largura da componente  *por mim nao existiria
		c.ipady = ipady;	//adiciona a altura da componente  *por mim nao existiria
		c.gridheight = gridheight;  //quantas celulas a componente ocupara na vertical
		c.gridwidth = gridwidth;	//quantas celulas a componeente ocupara na horizontal
		c.weightx = weightx;		//peso da componente no eixo x
		c.weighty = weighty; 		//peso da componente no eixo y
		c.insets = new Insets(i1,i2,i3,i4);  //incremento de bordas em (cima,esquerda,baixo,direita);
		return c;
	}
}