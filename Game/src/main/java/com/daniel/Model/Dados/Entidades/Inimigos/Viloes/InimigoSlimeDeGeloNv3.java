package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeGeloNv3 extends Inimigo {
    public InimigoSlimeDeGeloNv3() {
        super("Slime de gelo grande", "/com.daniel.Images/Inimigos/Slime Iceiii.png", 10, 40, 35, 45, 40, 30,5, 5, TiposElementais.Gelo, Comportamentos.padrao, 300, 105);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.Gelo};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
    }
}
