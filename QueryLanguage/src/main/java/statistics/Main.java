package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new And(new HasAtLeast(10, "goals"),
//                new HasAtLeast(10, "assists"),
//                new PlaysIn("PHI")
//        );
//
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
//        QueryBuilder query = new QueryBuilder();
//
//        Matcher m = query.playsIn("NYR")
//                .hasAtLeast(10, "goals")
//                .hasFewerThan(25, "assists").build();
        QueryBuilder q1 = new QueryBuilder()
                .playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").and();

        QueryBuilder q2 = new QueryBuilder()
                .playsIn("EDM")
                .hasAtLeast(60, "points").and();

        Matcher m = q1.or(q2.build()).build();
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
