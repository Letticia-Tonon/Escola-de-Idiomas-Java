package org.example;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JButton professorButton;
    private JPanel painel;
    private JFormattedTextField escolaDeIdiomasFormattedTextField;
    private JButton alunoButton;

    public Principal() {
        setContentPane(painel);
        setTitle("Escola de Idiomas");
        setSize(500,500);
        setLocation(1,1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        JMenuBar menu = new JMenuBar();
        // Define e adiciona dois menus drop down na barra de menus
        JMenu menu1 = new JMenu("Professores");
        JMenu menu2 = new JMenu("Aluno");
//        JMenu menu3 = new JMenu("Receita");
//        JMenu menu4 = new JMenu("Exames");
//        JMenu menu5 = new JMenu("Recepcionista");
        menu.add(menu1);
        menu.add(menu2);
//        menu.add(menu3);
//        menu.add(menu4);
//        menu.add(menu5);
        setJMenuBar(menu);


        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaProfessores janPr = new JanelaProfessores();
            }
        });

        menu1.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JanelaProfessores janPr = new JanelaProfessores();
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });


        alunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaAlunos janPr = new JanelaAlunos();
            }
        });

        menu2.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JanelaAlunos janPr = new JanelaAlunos();
            }
            @Override
            public void menuDeselected(MenuEvent e) { }
            @Override
            public void menuCanceled(MenuEvent e) { }
        });
    }


}
