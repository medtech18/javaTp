package belote;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BeloteInterface {
	static final String PATH_TO_IMAGES = "src/images/";

	JFrame frameJeuDeBelotte;

	String nomNord;
	String nomSud;
	String nomEst;
	String nomOuest;
	Belote belote;
	
	boolean remporteClicked;

	JLabel labelJoueurSud;
	JLabel labelJoueurEst;
	JLabel labelJoueurOuest;
	JLabel labelJoueurNord;

	JLabel commentaire;
	JLabel carteJoueurNordLabel;
	JLabel carteJoueurSudLabel;
	JLabel carteJoueurEstLabel;
	JLabel carteJoueurOuestLabel;

	BeloteInterface(String nomNord, String nomSud, String nomEst, String nomOuest) {
		
		belote = new Belote(nomNord,nomSud,nomEst,nomOuest);
		this.nomNord  	  	 = 	nomNord;
		this.nomSud	  	  	 = 	nomSud;
		this.nomEst   	  	 = 	nomEst;
		this.nomOuest 	  	 = 	nomOuest;
		this.remporteClicked =  false;
		initFrame();
	}

	void jouer() 
	{
		commentaire.setText("Commentaire");
		belote.distribue();
		afficheCarteJoueur(JoueurPosition.NORD, belote.joueurNord.carte);
		afficheCarteJoueur(JoueurPosition.OUEST, belote.joueurOuest.carte);
		afficheCarteJoueur(JoueurPosition.SUD, belote.joueurSud.carte);
		afficheCarteJoueur(JoueurPosition.EST, belote.joueurEst.carte);
		commentaire.setText(belote.mains());
		remporteClicked = false; // pour eviter de remporter le pli plusieurs fois sans jouer 
	}

	void remporter() 
	{
		int pointGagne = 0;
		Joueur gagnant = belote.gagnant();
		int points 	   = belote.points();
		pointGagne = points ;
		
		if(remporteClicked == true)
		{
			pointGagne = 0;
		}else
		{
			remporteClicked = true;
		}

		
		String msg = "<html>";
		msg += "C'est " + gagnant.nom + " avec son " + gagnant.carte.getNom();
		msg += "<br/> qui remporte " + points + " points!<br/>";
		msg += "</html>";
		commentaire.setText(msg);
		
		
		if(gagnant == belote.joueurNord)
		{
			belote.joueurNord.remporte(pointGagne);
			belote.joueurSud.remporte(pointGagne);
		}else if(gagnant == belote.joueurEst)
		{
			belote.joueurEst.remporte(pointGagne);
			belote.joueurOuest.remporte(pointGagne);
		}else if(gagnant == belote.joueurSud)
		{
			belote.joueurSud.remporte(pointGagne);
			belote.joueurNord.remporte(pointGagne);
		}else
		{
			belote.joueurOuest.remporte(pointGagne);
			belote.joueurEst.remporte(pointGagne);
		}
		
		setJoueurPoints(JoueurPosition.NORD, belote.joueurNord.nom, belote.joueurNord.points);
		setJoueurPoints(JoueurPosition.EST, belote.joueurEst.nom, belote.joueurEst.points);
		setJoueurPoints(JoueurPosition.SUD, belote.joueurSud.nom, belote.joueurSud.points);
		setJoueurPoints(JoueurPosition.OUEST, belote.joueurOuest.nom, belote.joueurOuest.points);

	
	
		afficheCarteJoueur(JoueurPosition.NORD, null);
		afficheCarteJoueur(JoueurPosition.EST, null);
		afficheCarteJoueur(JoueurPosition.SUD, null);
		afficheCarteJoueur(JoueurPosition.OUEST, null);

	}

	void afficheCarteJoueur(JoueurPosition position, Carte carte) 
	{
		switch(position)
		{
			case NORD:
				if(carte != null) 
				{
					carteJoueurNordLabel.setIcon(new ImageIcon(PATH_TO_IMAGES+carte.getFichierImage()));
				}
				else 
				{
					carteJoueurNordLabel.setIcon(null);
				}
				break;
			case EST :
				if(carte != null) 
				{
					carteJoueurEstLabel.setIcon(new ImageIcon(PATH_TO_IMAGES+carte.getFichierImage()));
				}
				else 
				{
					carteJoueurEstLabel.setIcon(null);
				}
				break;
			case SUD :
				if(carte != null)
				{
					carteJoueurSudLabel.setIcon(new ImageIcon(PATH_TO_IMAGES+carte.getFichierImage()));
				}
				else 
				{
					carteJoueurSudLabel.setIcon(null);
				}
				break;
			case OUEST:
				if(carte != null) 
				{
					carteJoueurOuestLabel.setIcon(new ImageIcon(PATH_TO_IMAGES+carte.getFichierImage()));
				}
				else 
				{
					carteJoueurOuestLabel.setIcon(null);
				}
				break;
			default:
				break;
		}
		
	}

	void setJoueurPoints(JoueurPosition position, String nom, int points) {
		//JLabel joueurLabel = null;
        // A compléter
		
		switch(position)
		{
			case NORD:
				labelJoueurNord.setText(nom + " (" + points + ")");
				break;
			case EST :
				labelJoueurEst.setText(nom + " (" + points + ")");
				break;
			case SUD :
				labelJoueurSud.setText(nom + " (" + points + ")");
				break;
			case OUEST:
				labelJoueurOuest.setText(nom + " (" + points + ")");
				break;
			default:
				break;
		}

	}

	void initFrame() {
		// Dimensions
		int xmin = 100;
		int xmax = 900;
		int ymin = 100;
		int ymax = 900;
		Dimension totalDimension = new Dimension(xmax - xmin, ymax - ymin);
		Dimension carteDimension = new Dimension(240, 360);
		Dimension cartePanelDimension = new Dimension(150, 150);
		Dimension joueurLabelDimensionNS = new Dimension(200, 50);
		Dimension joueurLabelDimensionEO = new Dimension(50, 200);
		Dimension joueurPanelDimension = new Dimension(250, 250);

		// Coueurs
		Color couleurTapis = new Color(0, 100, 0);
		Color couleurBGLabelJoueurNS = Color.BLUE;
		Color couleurBGLabelJoueurEO = Color.ORANGE;
		Color couleurLabelJoueurNS = Color.ORANGE;
		Color couleurLabelJoueurEO = Color.BLUE;
		Color couleurCoin = couleurTapis;
		Color couleurCommentaire = new Color(255, 255, 240);

		frameJeuDeBelotte = new JFrame();
		frameJeuDeBelotte.getContentPane().setMinimumSize(totalDimension);
		frameJeuDeBelotte.getContentPane().setPreferredSize(totalDimension);
		frameJeuDeBelotte.setTitle("Jeu de Belotte");
		frameJeuDeBelotte.getContentPane().setBackground(new Color(0, 100, 0));
		frameJeuDeBelotte.getContentPane()
				.setLayout(new BoxLayout(frameJeuDeBelotte.getContentPane(), BoxLayout.Y_AXIS));

		// Jeu
		// Joueurs

		JPanel jeuPanel = new JPanel();
		frameJeuDeBelotte.getContentPane().add(jeuPanel);
		GridLayout joueursLayout = new GridLayout(3, 3, 1, 1);
		jeuPanel.setLayout(joueursLayout);

		// Coin supérieur gauche
		JPanel coinGauchePanel = new JPanel();
		coinGauchePanel.setBackground(couleurCoin);
		coinGauchePanel.setLayout(new BoxLayout(coinGauchePanel, BoxLayout.X_AXIS));

		JLabel coinGaucheLabel = new JLabel("0, 0");
		coinGaucheLabel.setForeground(couleurCoin);
		coinGaucheLabel.setPreferredSize(joueurPanelDimension);
		coinGaucheLabel.setMinimumSize(joueurPanelDimension);
		coinGaucheLabel.setMaximumSize(joueurPanelDimension);
		coinGauchePanel.add(coinGaucheLabel);

		jeuPanel.add(coinGauchePanel, 0, 0);

		// Joueur Sud
		JPanel joueurSudPanel = new JPanel();
		joueurSudPanel.setBackground(couleurBGLabelJoueurNS);
		joueurSudPanel.setMinimumSize(joueurPanelDimension);
		joueurSudPanel.setLayout(new BoxLayout(joueurSudPanel, BoxLayout.Y_AXIS));

		JPanel joueurSudCartesPanel = new JPanel();
		joueurSudCartesPanel.setPreferredSize(cartePanelDimension);
		joueurSudCartesPanel.setMinimumSize(cartePanelDimension);
		joueurSudCartesPanel.setBackground(couleurTapis);
		joueurSudCartesPanel.setLayout(new GridLayout(1, 0, 20, 0));
		carteJoueurSudLabel = new JLabel();
		carteJoueurSudLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carteJoueurSudLabel.setPreferredSize(carteDimension);
		carteJoueurSudLabel.setMaximumSize(carteDimension);
		carteJoueurSudLabel.setMinimumSize(carteDimension);
		carteJoueurSudLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
		joueurSudCartesPanel.add(carteJoueurSudLabel);
		joueurSudPanel.add(joueurSudCartesPanel);

		JPanel labelJoueurSudPanel = new JPanel();
		labelJoueurSudPanel.setBackground(couleurBGLabelJoueurNS);
		labelJoueurSudPanel.setMaximumSize(joueurLabelDimensionNS);
		labelJoueurSudPanel.setLayout(new BoxLayout(labelJoueurSudPanel, BoxLayout.X_AXIS));
		labelJoueurSud = new JLabel(nomSud);
		labelJoueurSud.setHorizontalAlignment(JLabel.CENTER);
		labelJoueurSud.setPreferredSize(joueurLabelDimensionNS);
		labelJoueurSud.setForeground(couleurLabelJoueurNS);
		labelJoueurSudPanel.add(labelJoueurSud);
		joueurSudPanel.add(labelJoueurSudPanel);

		jeuPanel.add(joueurSudPanel, 0, 1);

		// Coin supérieur droit
		JPanel coinDroitPanel = new JPanel();
		coinDroitPanel.setBackground(couleurCoin);
		coinDroitPanel.setLayout(new BoxLayout(coinDroitPanel, BoxLayout.X_AXIS));

		JLabel coinDroitLabel = new JLabel("0, 2");
		coinDroitLabel.setForeground(couleurCoin);
		coinDroitLabel.setPreferredSize(joueurPanelDimension);
		coinDroitLabel.setMinimumSize(joueurPanelDimension);
		coinDroitLabel.setMaximumSize(joueurPanelDimension);
		coinDroitPanel.add(coinDroitLabel);

		jeuPanel.add(coinDroitPanel, 0, 2);

		// Joueur Est
		JPanel joueurEstPanel = new JPanel();
		joueurEstPanel.setBackground(couleurBGLabelJoueurEO);
		joueurEstPanel.setMinimumSize(joueurPanelDimension);
		joueurEstPanel.setLayout(new BoxLayout(joueurEstPanel, BoxLayout.X_AXIS));

		JPanel labelJoueurEstPanel = new JPanel();
		labelJoueurEstPanel.setBackground(couleurBGLabelJoueurEO);
		labelJoueurEstPanel.setMaximumSize(joueurLabelDimensionEO);
		labelJoueurEstPanel.setLayout(new BoxLayout(labelJoueurEstPanel, BoxLayout.X_AXIS));
		labelJoueurEst = new JLabel(nomEst);
		labelJoueurEst.setForeground(couleurLabelJoueurEO);
		labelJoueurEst.setHorizontalAlignment(JLabel.CENTER);
		labelJoueurEst.setPreferredSize(joueurLabelDimensionEO);
		labelJoueurEst.setUI(new VerticalLabelUI(false));
		labelJoueurEstPanel.add(labelJoueurEst);
		joueurEstPanel.add(labelJoueurEstPanel);

		JPanel joueurEstCartesPanel = new JPanel();
		joueurEstCartesPanel.setPreferredSize(cartePanelDimension);
		joueurEstCartesPanel.setMinimumSize(cartePanelDimension);
		joueurEstCartesPanel.setBackground(couleurTapis);
		joueurEstCartesPanel.setLayout(new GridLayout(0, 1, 20, 0));
		carteJoueurEstLabel = new JLabel();
		carteJoueurEstLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carteJoueurEstLabel.setPreferredSize(carteDimension);
		carteJoueurEstLabel.setMaximumSize(carteDimension);
		carteJoueurEstLabel.setMinimumSize(carteDimension);
		carteJoueurEstLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
		carteJoueurEstLabel.setUI(new VerticalLabelUI(false));
		joueurEstCartesPanel.add(carteJoueurEstLabel);
		joueurEstPanel.add(joueurEstCartesPanel);

		jeuPanel.add(joueurEstPanel, 1, 0);

		// Centre
		JPanel centrePanel = new JPanel();
		centrePanel.setBackground(couleurCoin);
		centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
		centrePanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		centrePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

		JButton btnRJouer = new JButton("Jouer");
		btnRJouer.setAlignmentX(JButton.CENTER_ALIGNMENT);
		btnRJouer.setAlignmentY(JButton.CENTER_ALIGNMENT);
		btnRJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jouer();
			}
		});
		centrePanel.add(btnRJouer);

		JButton btnRemporter = new JButton("Remporter");
		btnRemporter.setAlignmentX(JButton.CENTER_ALIGNMENT);
		btnRemporter.setAlignmentY(JButton.CENTER_ALIGNMENT);
		btnRemporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remporter();
			}
		});
		centrePanel.add(btnRemporter);

		commentaire = new JLabel("Commentaire");
		commentaire.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		commentaire.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		commentaire.setForeground(couleurCommentaire);
		commentaire.setHorizontalAlignment(SwingConstants.CENTER);
		centrePanel.add(commentaire);

		jeuPanel.add(centrePanel, 1, 1);

		// Joueur Ouest
		JPanel joueurOuestPanel = new JPanel();
		joueurOuestPanel.setBackground(couleurBGLabelJoueurEO);
		joueurOuestPanel.setMinimumSize(joueurPanelDimension);
		joueurOuestPanel.setLayout(new BoxLayout(joueurOuestPanel, BoxLayout.X_AXIS));

		JPanel joueurOuestCartesPanel = new JPanel();
		joueurOuestCartesPanel.setPreferredSize(cartePanelDimension);
		joueurOuestCartesPanel.setMinimumSize(cartePanelDimension);
		joueurOuestCartesPanel.setBackground(couleurTapis);
		joueurOuestCartesPanel.setLayout(new GridLayout(0, 1, 20, 0));
		carteJoueurOuestLabel = new JLabel();
		carteJoueurOuestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carteJoueurOuestLabel.setPreferredSize(carteDimension);
		carteJoueurOuestLabel.setMaximumSize(carteDimension);
		carteJoueurOuestLabel.setMinimumSize(carteDimension);
		carteJoueurOuestLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
		carteJoueurOuestLabel.setUI(new VerticalLabelUI(false));
		joueurOuestCartesPanel.add(carteJoueurOuestLabel);
		joueurOuestPanel.add(joueurOuestCartesPanel);

		JPanel labelJoueurOuestPanel = new JPanel();
		labelJoueurOuestPanel.setBackground(couleurBGLabelJoueurEO);
		labelJoueurOuestPanel.setMaximumSize(joueurLabelDimensionEO);
		labelJoueurOuestPanel.setLayout(new BoxLayout(labelJoueurOuestPanel, BoxLayout.X_AXIS));
		labelJoueurOuest = new JLabel(nomOuest);
		labelJoueurOuest.setForeground(couleurLabelJoueurEO);
		labelJoueurOuest.setHorizontalAlignment(JLabel.CENTER);
		labelJoueurOuest.setPreferredSize(joueurLabelDimensionEO);
		labelJoueurOuest.setUI(new VerticalLabelUI(true));
		labelJoueurOuestPanel.add(labelJoueurOuest);
		joueurOuestPanel.add(labelJoueurOuestPanel);

		jeuPanel.add(joueurOuestPanel, 1, 2);

		// Coin inférieur gauche
		JPanel coinBasGauchetPanel = new JPanel();
		coinBasGauchetPanel.setBackground(couleurCoin);
		coinBasGauchetPanel.setLayout(new BoxLayout(coinBasGauchetPanel, BoxLayout.X_AXIS));

		JLabel coinBasGaucheLabel = new JLabel("2, 0");
		coinBasGaucheLabel.setForeground(couleurCoin);
		coinBasGaucheLabel.setPreferredSize(joueurPanelDimension);
		coinBasGaucheLabel.setMinimumSize(joueurPanelDimension);
		coinBasGaucheLabel.setMaximumSize(joueurPanelDimension);
		coinBasGauchetPanel.add(coinBasGaucheLabel);

		jeuPanel.add(coinBasGauchetPanel, 2, 0);

		// Joueur Nord
		JPanel joueurNordPanel = new JPanel();
		joueurNordPanel.setBackground(couleurBGLabelJoueurNS);
		joueurNordPanel.setMinimumSize(joueurPanelDimension);
		joueurNordPanel.setLayout(new BoxLayout(joueurNordPanel, BoxLayout.Y_AXIS));

		JPanel labelJoueurNordPanel = new JPanel();
		labelJoueurNordPanel.setBackground(couleurBGLabelJoueurNS);
		labelJoueurNordPanel.setMaximumSize(joueurLabelDimensionNS);
		labelJoueurNordPanel.setLayout(new BoxLayout(labelJoueurNordPanel, BoxLayout.X_AXIS));
		labelJoueurNord = new JLabel(nomNord);
		labelJoueurNord.setForeground(couleurLabelJoueurNS);
		labelJoueurNord.setHorizontalAlignment(JLabel.CENTER);
		labelJoueurNord.setPreferredSize(joueurLabelDimensionNS);
		labelJoueurNordPanel.add(labelJoueurNord);
		joueurNordPanel.add(labelJoueurNordPanel);

		JPanel joueurNordCartesPanel = new JPanel();
		joueurNordCartesPanel.setPreferredSize(cartePanelDimension);
		joueurNordCartesPanel.setMinimumSize(cartePanelDimension);
		joueurNordCartesPanel.setBackground(couleurTapis);
		joueurNordCartesPanel.setLayout(new GridLayout(1, 0, 20, 0));

		carteJoueurNordLabel = new JLabel();
		carteJoueurNordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carteJoueurNordLabel.setPreferredSize(carteDimension);
		carteJoueurNordLabel.setMaximumSize(carteDimension);
		carteJoueurNordLabel.setMinimumSize(carteDimension);
		carteJoueurNordLabel.setIcon(new ImageIcon(PATH_TO_IMAGES + "dos-de-carte.png"));
		joueurNordCartesPanel.add(carteJoueurNordLabel);
		joueurNordPanel.add(joueurNordCartesPanel);

		jeuPanel.add(joueurNordPanel, 2, 1);

		// Coin inférieur droit
		JPanel coinBasDroitPanel = new JPanel();
		coinBasDroitPanel.setBackground(couleurCoin);
		coinBasDroitPanel.setLayout(new BoxLayout(coinBasDroitPanel, BoxLayout.X_AXIS));

		JLabel coinBasDroitLabel = new JLabel("2, 2");
		coinBasDroitLabel.setForeground(couleurCoin);
		coinBasDroitLabel.setPreferredSize(joueurPanelDimension);
		coinBasDroitLabel.setMinimumSize(joueurPanelDimension);
		coinBasDroitLabel.setMaximumSize(joueurPanelDimension);
		coinBasDroitPanel.add(coinBasDroitLabel);

		jeuPanel.add(coinBasDroitPanel, 2, 2);

		frameJeuDeBelotte.setBounds(xmin, ymin, xmax, ymax);
		frameJeuDeBelotte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
