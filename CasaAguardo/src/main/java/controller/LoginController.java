package controller;

import view.LoginView;

public class LoginController {

    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnEntrar().setOnAction(
            event -> realizarLogin()
        );
    }

    // =========================================================
    // REALIZA LOGIN
    // =========================================================

    private void realizarLogin() {

        String usuario =
                view.getTxtUsuario()
                    .getText()
                    .trim();

        String senha =
                view.getTxtSenha()
                    .getText();

        view.esconderErroUsuario();
        view.esconderErroSenha();

        boolean possuiErro = false;

        if (usuario.isEmpty()) {

            view.mostrarErroUsuario(
                "Digite seu usuário."
            );

            possuiErro = true;
        }

        if (senha.isEmpty()) {

            view.mostrarErroSenha(
                "Digite sua senha."
            );

            possuiErro = true;
        }

        if (possuiErro) {

            if (usuario.isEmpty()) {
                view.getTxtUsuario().requestFocus();
            } else {
                view.getTxtSenha().requestFocus();
            }
            return;
        }

        // =====================================================
        // TESTE TEMPORÁRIO
        // =====================================================

        System.out.println(
            "Usuário informado: " + usuario
        );

        System.out.println(
            "Senha informada."
        );


        /*
         * =====================================================
         * FUTURAMENTE
         * =====================================================
         *
         * Aqui entra a comunicação com o back-end.
         *
         * Exemplo:
         *
         * boolean autenticado =
         *      loginService.autenticar(
         *          usuario,
         *          senha
         *      );
         *
         * if (autenticado) {
         *
         *      abrirTelaPrincipal();
         *
         * } else {
         *
         *      view.mostrarErroUsuario(
         *          "Usuário ou senha inválidos."
         *      );
         * }
         *
         */
    }
}