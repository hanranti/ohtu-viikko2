package statistics.matcher;

import statistics.Player;
import statistics.matcher.Matcher;

public class Not implements Matcher {

    private Matcher[] matchers;

    public Not(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
