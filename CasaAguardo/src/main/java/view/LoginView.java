package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginView {

    // =========================================================
    // COMPONENTES
    // =========================================================

    private TextField txtUsuario;
    private PasswordField txtSenha;
    private Button btnEntrar;

    private Label lblErroUsuario;
    private Label lblErroSenha;

    private StackPane rootLayout;

    public LoginView() {
        criarLayout();
    }

    private void criarLayout() {

        Image logo = new Image(
            getClass().getResourceAsStream("/images/logosb.png")
        );

        ImageView logoView = new ImageView(logo);

        logoView.setFitWidth(420);
        logoView.setFitHeight(420);
        logoView.setPreserveRatio(true);
        logoView.setTranslateX(-80);

        VBox headerBox = new VBox(6);

        headerBox.setAlignment(Pos.CENTER);

        headerBox.setPadding(
            new Insets(30, 20, 25, 20)
        );

        headerBox.setStyle(
            "-fx-background-color: #b71c1c;" +
            "-fx-background-radius: 16 16 0 0;"
        );


        Label lblTitulo = new Label("CAPHO");

        lblTitulo.setFont(
            Font.font(
                "Segoe UI",
                FontWeight.BOLD,
                18
            )
        );

        lblTitulo.setTextFill(Color.WHITE);


        Label lblSubtitulo = new Label(
            "Casa do Aguardo Professor Hideo Okuyama"
        );

        lblSubtitulo.setFont(
            Font.font(
                "Segoe UI",
                FontWeight.NORMAL,
                11
            )
        );

        lblSubtitulo.setTextFill(
            Color.web("#ffdada")
        );


        headerBox.getChildren().addAll(
            lblTitulo,
            lblSubtitulo
        );

        VBox formBox = new VBox(8);

        formBox.setPadding(
            new Insets(25, 30, 25, 30)
        );

        formBox.setAlignment(
            Pos.TOP_LEFT
        );

        Label lblFacaLogin = new Label(
            "Faça seu login"
        );

        lblFacaLogin.setFont(
            Font.font(
                "Segoe UI",
                FontWeight.BOLD,
                15
            )
        );

        lblFacaLogin.setTextFill(
            Color.web("#2c3e50")
        );

        lblFacaLogin.setMaxWidth(
            Double.MAX_VALUE
        );

        lblFacaLogin.setAlignment(
            Pos.CENTER
        );

        VBox.setMargin(
            lblFacaLogin,
            new Insets(0, 0, 8, 0)
        );

        Label lblUsuario = new Label(
            "Usuário"
        );

        lblUsuario.setFont(
            Font.font(
                "Segoe UI",
                12
            )
        );

        lblUsuario.setTextFill(
            Color.web("#555555")
        );


        txtUsuario = new TextField();

        txtUsuario.setPromptText(
            "Digite seu usuário"
        );

        txtUsuario.setPrefHeight(38);

        aplicarEstiloNormal(txtUsuario);

        lblErroUsuario = criarLabelErro();

        Label lblSenha = new Label(
            "Senha"
        );

        lblSenha.setFont(
            Font.font(
                "Segoe UI",
                12
            )
        );

        lblSenha.setTextFill(
            Color.web("#555555")
        );


        txtSenha = new PasswordField();

        txtSenha.setPromptText(
            "Digite sua senha"
        );

        txtSenha.setPrefHeight(38);

        aplicarEstiloNormal(txtSenha);

        lblErroSenha = criarLabelErro();

        btnEntrar = new Button(
            "Entrar"
        );

        btnEntrar.setPrefHeight(40);

        btnEntrar.setMaxWidth(
            Double.MAX_VALUE
        );

        btnEntrar.setFont(
            Font.font(
                "Segoe UI",
                FontWeight.BOLD,
                14
            )
        );

        btnEntrar.setTextFill(Color.WHITE);

        btnEntrar.setStyle(
            "-fx-background-color: #b71c1c;" +
            "-fx-background-radius: 8;" +
            "-fx-cursor: hand;"
        );

        Label lblFooter = new Label(
            "Casa do Aguardo"
        );

        lblFooter.setFont(
            Font.font(
                "Segoe UI",
                11
            )
        );

        lblFooter.setTextFill(
            Color.web("#888888")
        );

        lblFooter.setMaxWidth(
            Double.MAX_VALUE
        );

        lblFooter.setAlignment(
            Pos.CENTER
        );

        VBox.setMargin(
            lblFooter,
            new Insets(10, 0, 0, 0)
        );


        // =====================================================
        // ADICIONA COMPONENTES AO FORMULÁRIO
        // =====================================================

        formBox.getChildren().addAll(

            lblFacaLogin,

            // Usuário
            lblUsuario,
            txtUsuario,
            lblErroUsuario,

            // Senha
            lblSenha,
            txtSenha,
            lblErroSenha,

            // Botão
            btnEntrar,

            // Rodapé
            lblFooter
        );

        VBox card = new VBox();

        card.setPrefWidth(340);
        card.setMinWidth(340);
        card.setMaxWidth(340);

        card.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-background-radius: 16;"
        );

        DropShadow shadow = new DropShadow();

        shadow.setColor(
            Color.rgb(0, 0, 0, 0.15)
        );

        shadow.setRadius(15);

        shadow.setOffsetY(6);

        card.setEffect(shadow);


        card.getChildren().addAll(
            headerBox,
            formBox
        );

        HBox content = new HBox();

        content.setAlignment(
            Pos.CENTER
        );

        content.setSpacing(120);

        content.setPadding(
            new Insets(40)
        );

        content.getChildren().addAll(
            logoView,
            card
        );

        rootLayout = new StackPane(
            content
        );

        rootLayout.setStyle(
            "-fx-background-color: #f2f3f5;"
        );

        txtUsuario.textProperty().addListener(
            (obs, oldValue, newValue) -> {

                if (!newValue.trim().isEmpty()) {
                    esconderErroUsuario();
                }
            }
        );

        txtSenha.textProperty().addListener(
            (obs, oldValue, newValue) -> {

                if (!newValue.isEmpty()) {
                    esconderErroSenha();
                }
            }
        );
    }

    private Label criarLabelErro() {

        Label label = new Label();

        label.setTextFill(
            Color.web("#e53935")
        );

        label.setFont(
            Font.font(
                "Segoe UI",
                11
            )
        );

        label.setVisible(false);

        label.setManaged(false);

        return label;
    }

    private void aplicarEstiloNormal(
            TextField campo) {

        campo.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #e0e0e0;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-padding: 0 10 0 10;"
        );
    }

    private void aplicarEstiloErro(
            TextField campo) {

        campo.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #e53935;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-padding: 0 10 0 10;"
        );
    }


    // =========================================================
    // MOSTRAR ERRO DO USUÁRIO
    // =========================================================

    public void mostrarErroUsuario(
            String mensagem) {
        lblErroUsuario.setText(
            mensagem
        );
        lblErroUsuario.setVisible(true);
        lblErroUsuario.setManaged(true);
        aplicarEstiloErro(
            txtUsuario
        );
    }

    public void esconderErroUsuario() {
        lblErroUsuario.setText("");
        lblErroUsuario.setVisible(false);
        lblErroUsuario.setManaged(false);
        aplicarEstiloNormal(
            txtUsuario
        );
    }

    public void mostrarErroSenha(
            String mensagem) {

        lblErroSenha.setText(
            mensagem
        );
        lblErroSenha.setVisible(true);
        lblErroSenha.setManaged(true);
        aplicarEstiloErro(
            txtSenha
        );
    }

    public void esconderErroSenha() {
        lblErroSenha.setText("");
        lblErroSenha.setVisible(false);
        lblErroSenha.setManaged(false);
        aplicarEstiloNormal(
            txtSenha
        );
    }

    public Parent getRoot() {
        return rootLayout;
    }

    public TextField getTxtUsuario() {
        return txtUsuario;
    }

    public PasswordField getTxtSenha() {
        return txtSenha;
    }

    public Button getBtnEntrar() {
        return btnEntrar;
    }
}