package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlime extends Inimigo {
    public InimigoSlime() {
        super("Slime", "/com.daniel.Images/Inimigos/Slime Blue.png", 5, 5, 10, 5, 5, 10, 10, 5, 30, 10, TiposElementais.NaoElemental, Comportamentos.padrao);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fogo());
        this.magias.add(new Gelo());
        this.magias.add(new Luz());
        this.magias.add(new Escuridao());
    }
}
