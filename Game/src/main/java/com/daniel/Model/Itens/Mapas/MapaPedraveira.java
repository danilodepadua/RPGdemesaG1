package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.BatalhaDePedraveira;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaPedraveira extends Item implements IConsumableOutBattle {
    public MapaPedraveira() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Pedraveira", "Pedraveira"), 1, 200, new TextoNode("Mapa para Cidade de Pedraveira","Map to Pedraveira"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new BatalhaDePedraveira());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
