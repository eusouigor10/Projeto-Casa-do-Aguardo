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

    private TextField txtUsuario;
    private PasswordField txtSenha;
    private Button btnEntrar;
    private StackPane rootLayout;

    public LoginView() {
        criarLayout();
    }

    private void criarLayout() {

        // =========================================================
        // 1. LOGO - LADO ESQUERDO
        // =========================================================

        Image logo = new Image(
            getClass().getResourceAsStream("/images/logosb.png")
        );

        ImageView logoView = new ImageView(logo);

        logoView.setFitWidth(420);
        logoView.setFitHeight(420);
        logoView.setPreserveRatio(true);


        // =========================================================
        // 2. CABEÇALHO DO LOGIN
        // =========================================================

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


        // =========================================================
        // 3. FORMULÁRIO
        // =========================================================

        VBox formBox = new VBox(12);

        formBox.setPadding(
            new Insets(25, 30, 25, 30)
        );

        formBox.setAlignment(
            Pos.TOP_LEFT
        );


        // Título

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


        // =========================================================
        // USUÁRIO
        // =========================================================

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

        txtUsuario.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #e0e0e0;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-padding: 0 10 0 10;"
        );


        txtUsuario.focusedProperty().addListener(
            (obs, oldVal, newVal) -> {

                txtUsuario.setStyle(
                    newVal
                    ?
                    "-fx-background-color: #ffffff;" +
                    "-fx-border-color: #b71c1c;" +
                    "-fx-border-radius: 6;" +
                    "-fx-background-radius: 6;" +
                    "-fx-padding: 0 10 0 10;"

                    :

                    "-fx-background-color: #ffffff;" +
                    "-fx-border-color: #e0e0e0;" +
                    "-fx-border-radius: 6;" +
                    "-fx-background-radius: 6;" +
                    "-fx-padding: 0 10 0 10;"
                );
            }
        );


        // =========================================================
        // SENHA
        // =========================================================

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

        txtSenha.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #e0e0e0;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-padding: 0 10 0 10;"
        );


        txtSenha.focusedProperty().addListener(
            (obs, oldVal, newVal) -> {

                txtSenha.setStyle(
                    newVal
                    ?
                    "-fx-background-color: #ffffff;" +
                    "-fx-border-color: #b71c1c;" +
                    "-fx-border-radius: 6;" +
                    "-fx-background-radius: 6;" +
                    "-fx-padding: 0 10 0 10;"

                    :

                    "-fx-background-color: #ffffff;" +
                    "-fx-border-color: #e0e0e0;" +
                    "-fx-border-radius: 6;" +
                    "-fx-background-radius: 6;" +
                    "-fx-padding: 0 10 0 10;"
                );
            }
        );


        // =========================================================
        // BOTÃO ENTRAR
        // =========================================================

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

        btnEntrar.setTextFill(
            Color.WHITE
        );

        btnEntrar.setStyle(
            "-fx-background-color: #b71c1c;" +
            "-fx-background-radius: 8;" +
            "-fx-cursor: hand;"
        );


        // =========================================================
        // RODAPÉ
        // =========================================================

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


        // Adiciona componentes

        formBox.getChildren().addAll(
            lblFacaLogin,
            lblUsuario,
            txtUsuario,
            lblSenha,
            txtSenha,
            btnEntrar,
            lblFooter
        );


        // =========================================================
        // 4. CARD DO LOGIN - LADO DIREITO
        // =========================================================

        VBox card = new VBox();

        card.setPrefWidth(340);
        card.setMinWidth(340);
        card.setMaxWidth(340);

        card.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-background-radius: 16;"
        );


        // Sombra

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


        // =========================================================
        // 5. LOGO + LOGIN
        // =========================================================

        HBox content = new HBox();

        content.setAlignment(
            Pos.CENTER
        );

        content.setSpacing(120);

        content.setPadding(
            new Insets(40)
        );


        // Logo à esquerda
        // Card à direita

        content.getChildren().addAll(
            logoView,
            card
        );


        // =========================================================
        // 6. CONTAINER PRINCIPAL
        // =========================================================

        rootLayout = new StackPane(
            content
        );

        rootLayout.setStyle(
            "-fx-background-color: #f2f3f5;"
        );
    }


    // =============================================================
    // GET ROOT
    // =============================================================

    public Parent getRoot() {
        return rootLayout;
    }


    // =============================================================
    // GETTERS
    // =============================================================

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