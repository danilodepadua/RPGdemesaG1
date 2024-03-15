package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Dados.Cidades.Vilas.*;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.MainController.audioPlayerInicial;
import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class ConfigController implements Initializable {
    @FXML
    private ChoiceBox<String> EscolhaResolucao;
    @FXML
    private ChoiceBox<String> EscolhaIdioma;
    @FXML
    private Slider SliderVelBatalha;

    @FXML
    private Slider SliderVelHistoria;

    @FXML
    private Slider SliderVolume;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private VBox vboxcentro;

    boolean telaInicial = true;

    @FXML
    void Salvar(ActionEvent event) {
        String[] tamanho = EscolhaResolucao.getValue().split("x");
        int largura = Integer.parseInt(tamanho[0]);
        int altura = Integer.parseInt(tamanho[1]);
        Main.MudarTamanhoTela(largura, altura);
        ConfiguracoesUsuario.salvarAlturaTela(altura);
        ConfiguracoesUsuario.salvarLarguraTela(largura);
        ConfiguracoesUsuario.salvarVolume(SliderVolume.getValue());
        ConfiguracoesUsuario.salvarVelelocidadeTextoHistoria(SliderVelHistoria.getValue());
        ConfiguracoesUsuario.salvarVelelocidadeTextoBatalha(SliderVelBatalha.getValue());
        ConfiguracoesUsuario.salvarIdioma(EscolhaIdioma.getValue());
        Utilidades.AlinharHorizontal(vboxcentro, 0.5);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utilidades.AlinharHorizontal(vboxcentro, 0.5);
        EscolhaResolucao.getItems().addAll("1200x675", "1280x720");
        EscolhaIdioma.getItems().addAll("Português", "English");

        configurarBotoes(btnSalvar);
        contornarBotaoVoltar(btnVoltar);

        EscolhaResolucao.setValue(ConfiguracoesUsuario.obterLarguraTelaPadrao() + "x" + ConfiguracoesUsuario.obterAlturaTelaPadrao());

        SliderVolume.setValue(ConfiguracoesUsuario.obterVolumePadrao()*100);
        SliderVelBatalha.setValue(ConfiguracoesUsuario.obterVelelocidadeTextoBatalhaPadrao()-1);
        SliderVelHistoria.setValue(ConfiguracoesUsuario.obterVelelocidadeTextoHistoriaPadrao()-1);
        SliderVolume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                audioPlayerInicial.configVolume(SliderVolume.getValue()/100);
            }
        });

        try{
            Player.getPlayer();
            telaInicial = false;
        }
        catch (PlayerInexistenteException e){
            telaInicial = true;
        }
    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        if(telaInicial){
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInicial.fxml")).load());
        }
        else {
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
        }
    }
}

