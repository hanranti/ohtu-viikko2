package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;

    private HashMap<JButton, Komento> komennot;

    private Komento edellinen;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        sovellus.nollaa();

        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Plus(sovellus, syotekentta, tuloskentta));
        this.komennot.put(miinus, new Miinus(sovellus, syotekentta, tuloskentta));
        this.komennot.put(nollaa, new Nollaa(sovellus, syotekentta, tuloskentta));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        Komento komento = komennot.get(ae.getSource());
        if (komento != null) {
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }

        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(edellinen != null);
    }

}
