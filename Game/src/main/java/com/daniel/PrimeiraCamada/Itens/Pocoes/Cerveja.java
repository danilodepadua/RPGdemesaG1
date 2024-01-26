package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;

public class Cerveja extends Item implements IConsumableInBattle {
    public Cerveja(){
        super("/com.daniel.Images/Itens/Poções/canecadecerveja.png","Cerveja", 1, 20, "Poção que concede pontos 5 de força, 7 de resistência, perde 3 de vida e 6 de velocidade durante a batalha");
    }

    public Cerveja(int quant) {
        super("/com.daniel.Images/Itens/Poções/canecadecerveja.png","Cerveja", quant, 20, "Poção que concede pontos 5 de força, 7 de resistência, perde 3 de vida e 6 de velocidade durante a batalha");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        p.UpVel(-6);
        p.UpRes(7);
        p.tomarDano(3, TiposElementais.NaoElemental, true);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "Jogador ganhou mais 5 de força, 7 de resistência, perdeu 3 de vida e 6 de velocidade";
    }
}
