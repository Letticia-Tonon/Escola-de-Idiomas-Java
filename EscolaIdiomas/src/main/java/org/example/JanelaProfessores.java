package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class JanelaProfessores extends JFrame{
    private JPanel painel;
    private JLabel lblMensagem;
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton gravarButton;
    private JButton alterarButton;
    private JButton removerButton;
    private JFormattedTextField escolaDeIdiomasFormattedTextField;

    public JanelaProfessores()   {
        setContentPane(painel);
        setTitle("Cadastro de Professores");
        setSize(500,500);
        setLocation(1,1);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);

        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMensagem.setText("registro gravado com sucesso!");
            }
        });
        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] senhaChars = txtSenha.getPassword();
                String senha = new String(senhaChars);
//                Principal janela = new Principal();
                ProfessoresDAO professoresDao = new ProfessoresDAO();
                Professores professores = new Professores(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),senha);
                ProfessoresDAO.inserir(professores);
                JanelaProfessores.this.dispose();
            }
        });
//        alterarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ProfessoresDAO professoresDao = new ProfessoresDAO();
//                char[] senhaChars = txtSenha.getPassword();
//                String senha = new String(senhaChars);
//                try {
//                    int id = Integer.parseInt(txtId.getText());
//                    Professores professores = new Professores(id, txtNome.getText(), txtEmail.getText(), senha);
//                    int linhasAfetadas = professoresDao.alterar(professores);
//                    if (linhasAfetadas > 0) {
//                        System.out.println("Alteração realizada com sucesso!");
//                    } else {
//                        System.out.println("Não foi possível realizar a alteração.");
//                    }
//                    JanelaProfessores.this.dispose();
//                } catch (NumberFormatException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfessoresDAO professoresDao = new ProfessoresDAO();
                char[] senhaChars = txtSenha.getPassword();
                String senha = new String(senhaChars);
                try {
                    int id = Integer.parseInt(txtId.getText());
                    Professores professores = new Professores(id, txtNome.getText(), txtEmail.getText(), senha);
                    int linhasAfetadas = professoresDao.alterar(professores);
                    if (linhasAfetadas > 0) {
                        System.out.println("Alteração realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a alteração.");
                    }
                    JanelaProfessores.this.dispose();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    ex.getMessage();
                }
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfessoresDAO professoresDao = new ProfessoresDAO();
                char[] senhaChars = txtSenha.getPassword();
                String senha = new String(senhaChars);
                try{
                    int id = Integer.parseInt(txtId.getText());
                    System.out.println(id); // resultado = 25
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }

                Professores professores = new Professores(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),txtSenha.toString());
                professoresDao.remover(professores);
                JanelaProfessores.this.dispose();
            }
        });
    }

}
