package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField input, output;
    private int edellinen;

    public Nollaa(Sovelluslogiikka sovellus, JTextField input, JTextField output) {
        this.sovellus = sovellus;
        this.input = input;
        this.output = output;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();

        sovellus.nollaa();

        output.setText("" + sovellus.tulos());
        input.setText("");
    }

    @Override
    public void peru() {
        sovellus.setTulos(edellinen);
        output.setText("" + sovellus.tulos());
        input.setText("");
    }
}
