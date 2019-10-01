package jeuCarte;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BatailleInterface {
    static final String PATH_TO_IMAGES="src/images/";

    Bataille bataille;

    String nomGauche;
    String nomDroite;

    JFrame frameJeuDeBataille;

    JLabel commentaire;
    JLabel carteJoueurGaucheLabel;
    JLabel carteJoueurDroiteLabel;


    BatailleInterface(String nomGauche, String nomDroite) {

        bataille = new Bataille(nomGauche,nomDroite);
        this.nomGauche = nomGauche ;
        this.nomDroite = nomDroite;

        initFrame();
    }

    void jouer() {
        bataille.distribue();
        afficheCarteJoueur(1,bataille.joueur2.carte);
        afficheCarteJoueur(2,bataille.joueur1.carte);
    }

    void remporter() {
        // A compléter
    }

    void afficheCarteJoueur(int joueur, Carte carte) {
        // A compléter

        if (joueur == 1)
        {
            if(carte == null)
            {
                carteJoueurDroiteLabel.setIcon(null);
                return;
            }
            carteJoueurDroiteLabel.setIcon(new ImageIcon("/Users/simo/IdeaProjects/javaTp/TP3/jeuCarte/src/images/"+bataille.joueur2.carte.getFichierImage()));
        }else
        {
            if(carte == null)
            {
                carteJoueurGaucheLabel.setIcon(null);
                return;
            }
            carteJoueurGaucheLabel.setIcon(new ImageIcon("/Users/simo/IdeaProjects/javaTp/TP3/jeuCarte/src/images/"+bataille.joueur1.carte.getFichierImage()));
        }
    }

    void initFrame() {
        frameJeuDeBataille = new JFrame();
        frameJeuDeBataille.getContentPane().setMinimumSize(new Dimension(1000, 550));
        frameJeuDeBataille.getContentPane().setPreferredSize(new Dimension(1000, 550));
        frameJeuDeBataille.setTitle("Jeu de Bataille");
        frameJeuDeBataille.getContentPane().setBackground(new Color(0, 100, 0));
        frameJeuDeBataille.getContentPane().setLayout(new BoxLayout(frameJeuDeBataille.getContentPane(), BoxLayout.Y_AXIS));

        JPanel joueursPanel = new JPanel();
        frameJeuDeBataille.getContentPane().add(joueursPanel);
        joueursPanel.setLayout(new BoxLayout(joueursPanel, BoxLayout.X_AXIS));

        JPanel joueur1Panel = new JPanel();
        joueur1Panel.setBackground(new Color(100, 149, 237));
        joueursPanel.add(joueur1Panel);
        joueur1Panel.setLayout(new BoxLayout(joueur1Panel, BoxLayout.Y_AXIS));

        JLabel labelJoueur1 = new JLabel(nomGauche);
        labelJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
        joueur1Panel.add(labelJoueur1);

        JPanel joueur1CartesPanel = new JPanel();
        joueur1CartesPanel.setPreferredSize(new Dimension(500, 400));
        joueur1CartesPanel.setMinimumSize(new Dimension(500, 400));
        joueur1CartesPanel.setBackground(new Color(0, 100, 0));
        joueur1Panel.add(joueur1CartesPanel);
        joueur1CartesPanel.setLayout(new GridLayout(1, 0, 20, 0));

        JLabel tasJoueurGaucheLabel = new JLabel();
        tasJoueurGaucheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tasJoueurGaucheLabel.setPreferredSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setMaximumSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setMinimumSize(new Dimension(240, 360));
        tasJoueurGaucheLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
        joueur1CartesPanel.add(tasJoueurGaucheLabel);

        carteJoueurGaucheLabel = new JLabel();
        carteJoueurGaucheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carteJoueurGaucheLabel.setPreferredSize(new Dimension(240, 360));
        carteJoueurGaucheLabel.setMaximumSize(new Dimension(240, 360));
        carteJoueurGaucheLabel.setMinimumSize(new Dimension(240, 360));
        joueur1CartesPanel.add(carteJoueurGaucheLabel);

        JPanel joueur2Panel = new JPanel();
        joueur2Panel.setBackground(new Color(245, 222, 179));
        joueursPanel.add(joueur2Panel);
        joueur2Panel.setLayout(new BoxLayout(joueur2Panel, BoxLayout.Y_AXIS));

        JLabel labelJoueur2 = new JLabel(nomDroite);
        labelJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
        joueur2Panel.add(labelJoueur2);

        JPanel joueur2CartesPanel = new JPanel();
        joueur2CartesPanel.setPreferredSize(new Dimension(500, 400));
        joueur2CartesPanel.setMinimumSize(new Dimension(500, 400));
        joueur2CartesPanel.setBackground(new Color(0, 100, 0));
        joueur2Panel.add(joueur2CartesPanel);
        joueur2CartesPanel.setLayout(new GridLayout(1, 0, 20, 0));

        carteJoueurDroiteLabel = new JLabel();
        carteJoueurDroiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        carteJoueurDroiteLabel.setPreferredSize(new Dimension(240, 360));
        carteJoueurDroiteLabel.setMaximumSize(new Dimension(240, 360));
        carteJoueurDroiteLabel.setMinimumSize(new Dimension(240, 360));
        joueur2CartesPanel.add(carteJoueurDroiteLabel);

        JLabel tasJoueurDroiteLabel = new JLabel();
        tasJoueurDroiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tasJoueurDroiteLabel.setPreferredSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setMaximumSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setMinimumSize(new Dimension(240, 360));
        tasJoueurDroiteLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
        joueur2CartesPanel.add(tasJoueurDroiteLabel);

        JPanel commentairePanel = new JPanel();
        commentairePanel.setBackground(new Color(0, 100, 0));
        frameJeuDeBataille.getContentPane().add(commentairePanel);
        commentairePanel.setLayout(new BoxLayout(commentairePanel, BoxLayout.X_AXIS));

        commentaire = new JLabel("Commentaire");
        commentairePanel.add(commentaire);


        JPanel boutonsPanel = new JPanel();
        frameJeuDeBataille.getContentPane().add(boutonsPanel);
        boutonsPanel.setLayout(new BoxLayout(boutonsPanel, BoxLayout.X_AXIS));

        JButton btnRJouer = new JButton("Jouer");
        btnRJouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jouer();
            }
        });
        boutonsPanel.add(btnRJouer);

        JButton btnRemporter = new JButton("Remporter");
        btnRemporter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remporter();
            }
        });
        boutonsPanel.add(btnRemporter);

        commentaire.setForeground(new Color(255, 255, 240));
        commentaire.setHorizontalAlignment(SwingConstants.CENTER);
        frameJeuDeBataille.setBounds(100, 100, 1054, 490);
        frameJeuDeBataille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}