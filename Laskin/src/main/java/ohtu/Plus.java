package ohtu;

import javax.swing.JTextField;

public class Plus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField input, output;
    private int edellinen;

    public Plus(Sovelluslogiikka sovellus, JTextField input, JTextField output) {
        this.sovellus = sovellus;
        this.input = input;
        this.output = output;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        
        sovellus.plus(Integer.parseInt(input.getText()));
        
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
