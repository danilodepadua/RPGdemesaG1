package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;

public class CalcaCouro extends Calca {
    public CalcaCouro() {
        this.imagem = "/com.daniel.Images/Itens/CalcaCouro.png";
        this.nome ="Calça de Couro";
        this.preço = 140;
        this.aumentoDefesaFisica = 50;
        this.aumentoDefesaMagica = 14;
        this.descricao = "Concede um aumento de "+this.aumentoDefesaFisica+ " na defesa física e um aumento de " + this.aumentoDefesaMagica+ " na defesa mágica";

    }
}
