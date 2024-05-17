package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaAlunos extends JFrame{
    private JPanel painel;
    private JLabel manutencao;
    private JFormattedTextField escolaIdiomasFormattedTextField;
    private JButton voltarButton;
    private JLabel lblMensagem;
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton gravarButton;
    private JButton alterarButton;
    private JButton removerButton;
    public JanelaAlunos()   {
        setContentPane(painel);
        setTitle("Cadastro de Alunos");
        setSize(500,500);
        setLocation(1,1);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);

            voltarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                JanelaAlunos.this.dispose();
                                           }});
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lblMensagem.setText("registro gravado com sucesso!");
//            }
//        });
//        gravarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                Principal janela = new Principal();
//                AlunosDAO alunosDao = new AlunosDAO();
//                Alunos alunos = new Alunos(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),txtSenha.getPassword().toString());
//                alunosDao.inserir(alunos);
//            }
//        });
//        alterarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AlunosDAO alunosDao = new AlunosDAO();
//
//                try{
//                    int id = Integer.parseInt(txtId.getText());
//                    System.out.println(id); // resultado = 25
//                }
//                catch (NumberFormatException ex){
//                    ex.printStackTrace();
//                }
//
//                Alunos professores = new Alunos(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),txtSenha.getPassword().toString());
//                alunosDao.alterar(professores);
//            }
//        });
//
//        alterarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AlunosDAO alunosDao = new AlunosDAO();
//
//                try{
//                    int id = Integer.parseInt(txtId.getText());
//                    System.out.println(id); // resultado = 25
//                }
//                catch (NumberFormatException ex){
//                    ex.printStackTrace();
//                }
//
//                Alunos alunos = new Alunos(Integer.parseInt(txtId.getText()),txtNome.getText(),txtEmail.getText(),txtSenha.getPassword().toString());
//                alunosDao.remover(alunos);
//            }
//        });
   }

}
