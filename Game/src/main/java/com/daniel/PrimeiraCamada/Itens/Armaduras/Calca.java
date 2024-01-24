package com.daniel.PrimeiraCamada.Itens.Armaduras;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Armadura;

public class Calca extends Armadura implements IEquipable {
    /*public Calca(){
        this.aumentoDefesaFisica = 0;
        this.aumentoDefesaMagica= 0;
        this.imagem = "/com.daniel.Images/Itens/FundoCalça.png";
        this.nome = "Nenhum";
    }*/

    public Calca(String imgPath, String nome, int quant, int preco, String desc, int aumentoDefesaFisica, int aumentoDefesaMagica) {
        super(imgPath, nome, quant, preco, desc, aumentoDefesaFisica, aumentoDefesaMagica);
    }

    @Override
    public void equipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCalca();
        Player.getPlayer().equiparCalca(this);

    }

    @Override
    public void desequipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCalca();
    }
}
